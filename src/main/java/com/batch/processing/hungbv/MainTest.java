package com.batch.processing.hungbv;


import com.batch.processing.hungbv.dto.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainTest {

    public static void main(String[] args) {
        List<DataTable> tables = new ArrayList<>();

        tables.add(DataTable.builder().varSeq(1).lengthCol(1).startPosition(0).endPosition(1).build());
        tables.add(DataTable.builder().varSeq(2).lengthCol(6).startPosition(1).endPosition(7).build());
        tables.add(DataTable.builder().varSeq(3).lengthCol(6).startPosition(7).endPosition(13).build());
        tables.add(DataTable.builder().varSeq(4).lengthCol(1).startPosition(13).endPosition(14).build());
        tables.add(DataTable.builder().varSeq(5).lengthCol(6).startPosition(14).endPosition(20).build());
        tables.add(DataTable.builder().varSeq(6).lengthCol(6).startPosition(20).endPosition(26).build());
        //a|sdfghj|klbcm6|m|kjfhd|uiekvs -> dfghj|klbcm6|m|k
        int startPos = 1;
        int target = 6;
        int endPos = 7;
        Optional<DataTable> startPosition = tables.stream().filter(obj -> obj.getStartPosition() <= startPos
                && obj.getEndPosition() > startPos).findFirst();

        Optional<DataTable> endPosition = tables.stream().filter(obj -> obj.getStartPosition() < endPos
                && obj.getEndPosition() >= endPos).findFirst();

        if((startPosition.isEmpty() || endPosition.isEmpty())) {
            return;
        }

        int startIndex = tables.indexOf(startPosition.get());
        int endIndex = tables.indexOf(endPosition.get());
        List<DataTable> dataFind = tables.subList(startIndex, endIndex + 1);

        StringBuilder result = new StringBuilder();

        for(int i=0; i < dataFind.size(); i++) {
            target -= dataFind.get(i).getLengthCol();
            if(i > 0 && i + 1 < dataFind.size()) {

                result.append(dataFind.get(i).getVarSeq()).append(",0,0").append("-");
                continue;
            }
            int start0;
            int end0 = 0;
            String start = "";
            if(i == 0) {
                start0 = startPos - dataFind.get(i).getStartPosition();
                int end1;
                if(dataFind.size() == 1) {
                    end1 = endPos - dataFind.get(i).getStartPosition();
                } else {
                    end1 = dataFind.get(i).getLengthCol();
                }
                start0 = Math.max(start0, 0);

                start = start0 + "," + end1;
            } else {

                end0 = endPos - dataFind.get(i).getStartPosition();
                end0 = Math.max(end0, 0);
            }

            String temp = i == 0 ? start + "-": "0," + end0;

            result.append(dataFind.get(i).getVarSeq()).append(",").append(temp);


        }
        System.out.println("index: " + result);
        StringBuilder fi = new StringBuilder();
        for(int i = 0; i < result.toString().split("-").length; i++) {
            String[] a = "a|sdfghj|klbcm6|m|kjfphd|uiekvs".split("\\|");
            String[] arrIndex = result.toString().split("-")[i].split(",");
            String temp = a[Integer.parseInt(arrIndex[0])-1].substring(Integer.parseInt(arrIndex[1]), Integer.parseInt(arrIndex[2]));
            if(Integer.parseInt(arrIndex[1]) == 0 && Integer.parseInt(arrIndex[2]) == 0) {
                fi.append(a[Integer.parseInt(arrIndex[0])-1]).append("|");
                continue;
            }
            fi.append(temp).append("|");
        }
        System.out.println(fi);
    }
}

