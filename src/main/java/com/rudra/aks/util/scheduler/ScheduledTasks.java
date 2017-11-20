package com.rudra.aks.util.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks  {
	
	
	private static Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	/*
	 * This method will be invoked by task scheduler at given time for fixed invocation.
	 * time in miliseconds is specified by application.properties
	 * 
	 * 
	 */
	@Scheduled(initialDelayString = "${scheduler.initialDelay}", fixedRateString = "${scheduler.fixedRate}")
	public	void	runTaskAtFixedRate() {
		logger.info("Running scheduled tasks...");
	}
	
	
}
