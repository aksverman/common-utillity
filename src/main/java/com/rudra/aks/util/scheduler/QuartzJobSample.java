package com.rudra.aks.util.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJobSample	implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("---------------");
		System.out.println("Job is executing with quartz: ");
	}
	
}
