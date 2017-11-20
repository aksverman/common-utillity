package com.rudra.aks.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(
		exclude = {HibernateJpaAutoConfiguration.class, 
				DataSourceAutoConfiguration.class,
				DataSourceTransactionManagerAutoConfiguration.class} )
public class TestUtil implements CommandLineRunner{

	public static void main(String [] args) {
		
		SpringApplication.run(TestUtil.class, args);
		//SpringApplication.exit(SpringApplication.run(TestUtil.class, args));
	}
	
	@Autowired
	@Qualifier("defaultTemplate")
	JdbcTemplate	defaultTemplate;
	
	
	@Autowired
	@Qualifier("basicTemplate")
	JdbcTemplate	basicTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		
		getCountUsingDefaultTemplate();
		
		getCountUsingBasicTemplate();
		
				
	}

	

	private	void getCountUsingDefaultTemplate() {
		
		Integer count = defaultTemplate.queryForObject("select count(*) from CUST_XA", Integer.class);
		System.out.println("Total count of record using mysql template: " + count);
	}
	
	private	void getCountUsingBasicTemplate() {
		
		Integer count = basicTemplate.queryForObject("select count(*) from CUST_TX", Integer.class);
		System.out.println("Total count of record using BASIC template: " + count);
	}
	
}
