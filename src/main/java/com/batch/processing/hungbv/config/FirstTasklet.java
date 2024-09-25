package com.batch.processing.hungbv.config;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.List;

public class FirstTasklet implements Tasklet {
    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    private List<String> myList;

    public FirstTasklet(List<String> myList) {
        this.myList = myList;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        myList.forEach(System.out::println);
        // Logic của tasklet
        System.out.println("First CommonTasklet...");
        return RepeatStatus.FINISHED;
    }
}
