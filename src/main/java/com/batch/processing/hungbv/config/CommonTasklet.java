package com.batch.processing.hungbv.config;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.repeat.RepeatStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonTasklet implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // Logic của tasklet
        System.out.println("Executing CommonTasklet...");
        return RepeatStatus.FINISHED;
    }
}
