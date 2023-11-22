package com.example.Billingjob;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BillingJobConfig {

    @Bean
    public Job job(JobRepository jobRepository) {
        return new BillingJob(jobRepository);
    }
}
