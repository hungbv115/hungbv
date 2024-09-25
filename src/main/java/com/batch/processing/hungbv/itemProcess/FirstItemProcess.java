package com.batch.processing.hungbv.itemProcess;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FirstItemProcess implements ItemProcessor<Integer, Long> {

    @Override
    public Long process(Integer item) {
        System.out.println("Process!!!");
        return (long) (item + 20);
    }
}
