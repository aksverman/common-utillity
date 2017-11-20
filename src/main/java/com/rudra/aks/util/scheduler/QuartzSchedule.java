package com.rudra.aks.util.scheduler;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzSchedule {

	public static void main(String args []) {
		
		//Create job detail for defined job in below class
		JobDetail jobDetail = JobBuilder.newJob(QuartzJobSample.class)
										.withIdentity("job1")
										.build();
		
		SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
								.withIntervalInMilliseconds(4000)
								.repeatForever();
		
		/*create trigger to run the job descrbied above based on
		 * given schduled time 
		 */
		Trigger trigger = TriggerBuilder.newTrigger()
										.withIdentity("trigger1")
										.startNow()
										.withSchedule(simpleScheduleBuilder)
										.build();
		
		
				
		
		//execute the trigger with scheduler implementatio given by quartz
		try {
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(jobDetail, trigger);
			
		} catch (SchedulerException e) {
			System.err.println("Exception while scheduling : " + e);
		}
	}
}



