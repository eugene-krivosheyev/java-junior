package com.acme.edu;

import static com.acme.edu.TypeCodeEnum.NONE;

public class StatesDTO {

    private int similarStringCounter;
    private int integerSum;
    private int arrayIntSum;
    private int matrixIntSum;
    private int byteSum;
    private String prevString;
    private TypeCodeEnum prevTypeCodeEnum = NONE;

    public StatesDTO() {
        similarStringCounter = 0;
        integerSum = 0;
        arrayIntSum = 0;
        matrixIntSum = 0;
        byteSum = 0;
        prevString = "";
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

    public void setIntegerSum(int message) {
        this.integerSum = countSum(integerSum, message, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public void clearIntegerSum() {
        this.integerSum = 0;
    }

    public void setArrayIntSum(int message) {
        this.arrayIntSum = countSum(arrayIntSum, message, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public void clearArrayIntSum() {
        this.arrayIntSum = 0;
    }

    public void setMatrixIntSum(int message) {
        this.matrixIntSum = countSum(matrixIntSum, message, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public void clearMatrixIntSum() {
        this.matrixIntSum = 0;
    }

    public void setByteSum(byte message) {
        this.byteSum = countSum(byteSum, message, Byte.MAX_VALUE, Byte.MIN_VALUE);
    }

    public void clearByteSum() {
        this.byteSum = 0;
    }

    public void setPrevString(String prevString) {
        this.prevString = prevString;
    }

    public void setPrevTypeCodeEnum(TypeCodeEnum typeCodeEnum) {
        this.prevTypeCodeEnum = typeCodeEnum;
    }

    private static int countSum(int externalSum, int income, int max, int min) {
        long sum = (long) externalSum + (long) income;
        long result = checkOverflow(sum, max, min);

        if (result > sum) {
            Printer.print(Integer.toString(min));
        } else if (result < sum) {
            Printer.print(Integer.toString(max));
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
}
