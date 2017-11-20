package com.rudra.aks.util.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.rudra.aks.util.configuration.DataSourceUtilImpl;

@Configuration
@Import(value = DataSourceUtilImpl.class)
public class JdbcDBCPUtil {

	@Autowired
	@Qualifier("BasicDataSource")
	DataSource	basicDS;
		
	@Bean("basicTemplate")
	@DependsOn({"BasicDataSource"})
	public JdbcTemplate	getBasicTemplate() {
		return new JdbcTemplate(basicDS);
		
	}
	
		
	@Bean
	public	PlatformTransactionManager	txManagerDBCP() {
		return new DataSourceTransactionManager(basicDS);
	}
	
	/*	
	DataSource	getDBCP2() {
		return DataSourceUtilImpl.getDataSourceUtil().getBasicDataSource();
	}*/
}
