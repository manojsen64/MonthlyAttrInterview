package com.wns.mai.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonthlyInterviewJobInvokerController {

	@Autowired
	private JobLauncher jobLauncher;

    @Autowired
	private Job processJob;
	
	

	@RequestMapping("/invokejob")
	public String invoke() throws Exception {

		return "Batch job has been invoked with status : " + lunchJob();
	}

	@Scheduled(cron ="0/60 * * * * ?")
	public String lunchJob() throws Exception {
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				.toJobParameters();
		JobExecution status = jobLauncher.run(processJob, jobParameters);
		return status.getStatus().toString();
	}
	
	
}
