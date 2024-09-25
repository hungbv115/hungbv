package com.batch.processing.hungbv.batchprocessing;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class TimingStepExecutionListener extends StepExecutionListenerSupport {

    private long startTime;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        startTime = System.currentTimeMillis();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        // Kiểm tra thời gian thực thi
        if (duration > 12) {
            // Xử lý khi thời gian vượt quá ngưỡng
            return ExitStatus.FAILED.addExitDescription("Step exceeded time limit");
        }

        return ExitStatus.COMPLETED;
    }
}