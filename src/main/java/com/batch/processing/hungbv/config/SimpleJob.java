//package com.batch.processing.hungbv.config;
//
//import com.batch.processing.hungbv.service.FirstTasklet;
//import com.batch.processing.hungbv.service.SecondTasklet;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.PlatformTransactionManager;
//
//@Configuration
//public class SimpleJob {
//
//    @Bean
//    public Job firstJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//        return new JobBuilder("first-job", jobRepository)
//                .start(firstStep(jobRepository, transactionManager))
//                .next(secondTasklet(jobRepository, transactionManager))
//                .build();
//    }
//
//    private Step firstStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//        return new StepBuilder("first-step", jobRepository)
//                .tasklet(firstTasklet(), transactionManager)
//                .build();
//    }
//
//    private Step secondTasklet(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//        return new StepBuilder("second-step", jobRepository)
//                .tasklet(secondTasklet(), transactionManager)
//                .build();
//    }
//
//    private FirstTasklet firstTasklet() {
//        return new FirstTasklet();
//    }
//
//    private SecondTasklet secondTasklet() {
//        return new SecondTasklet();
//    }
//}
