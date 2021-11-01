package com.acme.edu;

import com.acme.edu.message.*;

import static com.acme.edu.TypeCodeEnum.NONE;

public class StatesDTO {

    private final Flusher flusher;
    private int similarStringCounter;
    private int integerSum;
    private int arrayIntSum;
    private int matrixIntSum;
    private int byteSum;
    private char prevChar;
    private boolean prevBoolean;
    private String prevString;
    private TypeCodeEnum prevTypeCodeEnum = NONE;

    public StatesDTO(Flusher flusher) {
        this.flusher = flusher;
        similarStringCounter = 0;
        integerSum = 0;
        arrayIntSum = 0;
        matrixIntSum = 0;
        byteSum = 0;
        prevString = "";
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

    public char getPrevChar() {
        return prevChar;
    }

    public void setPrevChar(CharMessage message) {
        this.prevChar = message.getMessage();
    }

    public boolean getPrevBoolean() {
        return prevBoolean;
    }

    public void setPrevBoolean(BooleanMessage message) {
        this.prevBoolean = message.getMessage();
    }

    public int getSimilarStringCounter() {
        return similarStringCounter;
    }

    public int getIntegerSum() {
        return integerSum;
    }

    public void setIntegerSum(IntMessage message) {
        this.integerSum = countSum(integerSum, message.getMessage(), Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public int getArrayIntSum() {
        return arrayIntSum;
    }

    private void setArrayIntSum(int message) {
        this.arrayIntSum = countSum(arrayIntSum, message, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public int getMatrixIntSum() {
        return matrixIntSum;
    }

    public int getByteSum() {
        return byteSum;
    }

    public void setByteSum(ByteMessage message) {
        this.byteSum = countSum(byteSum, message.getMessage(), Byte.MAX_VALUE, Byte.MIN_VALUE);
    }

    public String getPrevString() {
        return prevString;
    }

    public void setPrevString(String prevString) {
        this.prevString = prevString;
    }

    public TypeCodeEnum getPrevTypeCodeEnum() {
        return prevTypeCodeEnum;
    }

    public void setPrevTypeCodeEnum(TypeCodeEnum typeCodeEnum) {
        this.prevTypeCodeEnum = typeCodeEnum;
    }

    public void incSimilarStringCounter() {
        this.similarStringCounter++;
    }

    public void clearSimilarStringCounter() {
        this.similarStringCounter = 0;
    }

    public void clearIntegerSum() {
        this.integerSum = 0;
    }

    public void clearArrayIntSum() {
        this.arrayIntSum = 0;
    }

    public void clearMatrixIntSum() {
        this.matrixIntSum = 0;
    }

    public void clearByteSum() {
        this.byteSum = 0;
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

    public void arrayIncrementer(ArrayMessage message) {
        for (int i : message.getMessage()) {
            this.setArrayIntSum(i);
        }
    }

    public void matrixIncrementer(MatrixMessage message) {
        for (int[] row : message.getMessage()) {
            for (int i : row) {
                this.setArrayIntSum(i);
            }
        }
    }
}
