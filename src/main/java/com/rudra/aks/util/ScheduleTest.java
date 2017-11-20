package com.rudra.aks.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(
		exclude = {HibernateJpaAutoConfiguration.class, 
				DataSourceAutoConfiguration.class,
				DataSourceTransactionManagerAutoConfiguration.class} )
@EnableScheduling
public class ScheduleTest {


	public static void main(String[] args) {
		SpringApplication.run(ScheduleTest.class, args);
	}
	
	
	/*@Bean
	public	ThreadPoolTaskScheduler	taskScheduler() {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(2);
		taskScheduler.setThreadNamePrefix("Zeta-Thread");
		return taskScheduler;
	}*/

}
