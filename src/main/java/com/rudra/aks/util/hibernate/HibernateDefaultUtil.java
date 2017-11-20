package com.rudra.aks.util.hibernate;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

@Configuration
public class HibernateDefaultUtil {

	@Autowired
	@Qualifier("MySQLDataSource")
	DataSource	mysqlDS;
	
	
	@Bean
	@Autowired
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory)	{
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
	    hibernateTemplate.setCheckWriteOperations(false);
		return hibernateTemplate;
	}	
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	    return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(mysqlDS);
	    sessionBuilder.addPackage("com.rudra.aks.bo");
	    //sessionBuilder.addAnnotatedClass(CustomerBO.class);
	    return sessionBuilder.buildSessionFactory();
	}
	
	/*DataSource	getDataSource() {
		return DataSourceUtilImpl.getDataSourceUtil().getMySQLDataSource();
	}*/
}
