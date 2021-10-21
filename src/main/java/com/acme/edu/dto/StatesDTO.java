package com.acme.edu.dto;

import com.acme.edu.TypeCodeEnum;
import com.acme.edu.flush.Flusher;
import com.acme.edu.message.*;

import static com.acme.edu.TypeCodeEnum.NONE;

public class StatesDTO {

    private int similarStringCounter;
    private int integerSum;
    private int arrayIntSum;
    private int matrixIntSum;
    private int byteSum;
    private char prevChar;
    private boolean prevBoolean;
    private String prevString;
    private TypeCodeEnum prevTypeCodeEnum = NONE;
    private final Flusher flusher;

    public StatesDTO(Flusher flusher) {
        this.flusher = flusher;
        similarStringCounter = 0;
        integerSum = 0;
        arrayIntSum = 0;
        matrixIntSum = 0;
        byteSum = 0;
        prevString = "";
    }

    public char getPrevChar() {
        return prevChar;
    }

    public boolean getPrevBoolean() {
        return prevBoolean;
    }

    public int getSimilarStringCounter() {
        return similarStringCounter;
    }

    public int getIntegerSum() {
        return integerSum;
    }

    public int getArrayIntSum() {
        return arrayIntSum;
    }

    public int getMatrixIntSum() {
        return matrixIntSum;
    }

    public int getByteSum() {
        return byteSum;
    }

    public String getPrevString() {
        return prevString;
    }

    public TypeCodeEnum getPrevTypeCodeEnum() {
        return prevTypeCodeEnum;
    }

    public void incSimilarStringCounter() {
        this.similarStringCounter++;
    }

    public void clearSimilarStringCounter() {
        this.similarStringCounter = 0;
    }

    public void setIntegerSum(IntMessage message) {
        this.integerSum = countSum(integerSum, message.getMessage(), Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public void clearIntegerSum() {
        this.integerSum = 0;
    }

    private void setArrayIntSum(int message) {
        this.arrayIntSum = countSum(arrayIntSum, message, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public void clearArrayIntSum() {
        this.arrayIntSum = 0;
    }

    public void clearMatrixIntSum() {
        this.matrixIntSum = 0;
    }

    public void setByteSum(ByteMessage message) {
        this.byteSum = countSum(byteSum, message.getMessage(), Byte.MAX_VALUE, Byte.MIN_VALUE);
    }

    public void clearByteSum() {
        this.byteSum = 0;
    }

    public void setPrevChar(CharMessage message) {
        this.prevChar = message.getMessage();
    }

    public void setPrevBoolean(BooleanMessage message) {
        this.prevBoolean = message.getMessage();
    }

    public void setPrevString(String prevString) {
        this.prevString = prevString;
    }

    public void setPrevTypeCodeEnum(TypeCodeEnum typeCodeEnum) {
        this.prevTypeCodeEnum = typeCodeEnum;
    }

    private int countSum(int externalSum, int income, int max, int min) {
        long sum = (long) externalSum + (long) income;
        long result = checkOverflow(sum, max, min);

        if (result > sum) {
            flusher.flush(Integer.toString(min));
        } else if (result < sum) {
            flusher.flush(Integer.toString(max));
        }
        return (int) result;
    }

    private static long checkOverflow(long result, Integer max, Integer min) {
        if (result > max) {
            return result - max;
        }
        if (result < min) {
            return result + min;
        }
        return result;
    }

    public void arrayIncrementor(ArrayMessage message) {
        for (int i : message.getMessage()) {
            this.setArrayIntSum(i);
        }
    }

    public void matrixIncrementor(MatrixMessage message) {
        for (int[] row : message.getMessage()) {
            for (int i : row) {
                this.setArrayIntSum(i);
            }
        }
    }
}
