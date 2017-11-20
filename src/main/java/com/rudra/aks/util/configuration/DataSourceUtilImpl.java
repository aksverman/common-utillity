package com.rudra.aks.util.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@PropertySource("classpath:/dataSource.properties")
public class DataSourceUtilImpl implements DataSourceUtil {

	@Value("")
	String str;
	
	@Autowired 
	Environment env;
	
	
	public static DataSourceUtil	getDataSourceUtil() {
		return  new DataSourceUtilImpl();
	}
	
	/**
	 * This will get MySQL connection properties.
	 * 
	 */
	@Bean("MySQLDataSource")
	public DataSource getMySQLDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("db.mysql.driverClassName"));
		dataSource.setUrl(env.getProperty("db.mysql.url"));
		dataSource.setUsername(env.getProperty("db.mysql.username"));
		dataSource.setPassword(env.getProperty("db.mysql.password"));
		return dataSource;
	}

	@Bean("BasicDataSource")
	public DataSource getBasicDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("db.dbcp2.driverClassName"));
		dataSource.setUrl(env.getProperty("db.dbcp2.url"));
		dataSource.setUsername(env.getProperty("db.dbcp2.username"));
		dataSource.setPassword(env.getProperty("db.dbcp2.password"));
		
		//Initial Pool size after start
		dataSource.setInitialSize(5);
		
		//Max number of active connections [ default - 8]
		dataSource.setMaxTotal(10);
		
		//Max number of connections which may remain idle in pool [ default - 8]
		dataSource.setMaxIdle(2);
		
		//Max lifetime of a connection
		dataSource.setMaxConnLifetimeMillis(15000);
		
		//Max time pool will wait for returning connection, if no connection remains in pool
		dataSource.setMaxWaitMillis(30000);
		return dataSource;
	}
	

}
