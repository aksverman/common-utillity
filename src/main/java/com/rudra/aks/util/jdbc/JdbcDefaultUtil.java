package com.rudra.aks.util.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.rudra.aks.util.configuration.DataSourceUtilImpl;

@Configuration
@Import(value = DataSourceUtilImpl.class)
public class JdbcDefaultUtil {

	
	@Autowired
	@Qualifier("MySQLDataSource")
	DataSource	mysqlDS;
	
	
	@Bean("defaultTemplate")
	@DependsOn({"MySQLDataSource"})
	public JdbcTemplate	getJdbcTemplate() {
		return new JdbcTemplate(mysqlDS);
		
	}
	
	
	@Bean
	@Primary
	public	PlatformTransactionManager	txManagerDefault() {
		return new DataSourceTransactionManager(mysqlDS);
	}
	
		
	/*DataSource	getDefault() {
		return DataSourceUtilImpl.getDataSourceUtil().getMySQLDataSource();
	}*/
	
}
