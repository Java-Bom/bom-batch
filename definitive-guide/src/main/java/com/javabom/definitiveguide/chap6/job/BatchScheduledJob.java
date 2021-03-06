package com.javabom.definitiveguide.chap6.job;

import lombok.RequiredArgsConstructor;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.quartz.QuartzJobBean;

@RequiredArgsConstructor
public class BatchScheduledJob extends QuartzJobBean {
    private final Job chap5_quartz_job;
    private final JobExplorer jobExplorer;
    private final JobLauncher jobLauncher;


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobParameters jobParameters = new JobParametersBuilder(jobExplorer)
                .getNextJobParameters(chap5_quartz_job)
                .toJobParameters();
        try {
            jobLauncher.run(chap5_quartz_job, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
