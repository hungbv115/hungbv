package com.batch.processing.hungbv.itemWriter;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class FirstItemWriter implements ItemWriter<Integer> {
    @Override
    public void write(Chunk<? extends Integer> chunk) throws Exception {
        System.out.println("writer!!!!");
    }
}
