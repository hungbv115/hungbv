package com.batch.processing.hungbv.itemReader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class FirstItemReader implements ItemReader<Integer> {

    private List<String> myList;

    // Getter cho myList
    public List<String> getMyList() {
        return myList;
    }

    // Setter cho myList
    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    int i = 0;

    @Override
    public Integer read() {
        if(myList == null) return null;
        myList.forEach(System.out::println);
//        Integer item;
//        if(i < list.size()) {
//            item = list.get(i);
//            System.out.println("Item: " + item);
//            i++;
//            return item;
//        }

        return null;
    }
}
