package com.batch.processing.hungbv.dto;

import lombok.Builder;

@Builder
public class DataTable {
    private int varSeq;
    private int lengthCol;
    private int startPosition;
    private int endPosition;

    public int getVarSeq() {
        return varSeq;
    }

    public void setVarSeq(int varSeq) {
        this.varSeq = varSeq;
    }

    public int getLengthCol() {
        return lengthCol;
    }

    public void setLengthCol(int lengthCol) {
        this.lengthCol = lengthCol;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }
}
