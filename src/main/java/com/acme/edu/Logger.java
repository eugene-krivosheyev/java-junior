package com.acme.edu;

import java.util.Objects;

public class Logger {
    public static Type primitiveType = Type.PRIMITIVE;
    public static Type charType = Type.CHAR;
    public static Type stringType = Type.STRING;
    public static Type referenceType = Type.REFERENCE;

    private static boolean intAccumulateState = false;
    private static int intAccumulateSum = 0;

    private static boolean accumString = false;

    private static int strCount = 1;
    private static String lastStr = null;

    public static void log(int message) {
        checkIfStringIsEqualToLast(message);
        checkIfIntegerComesAsSequence(message);
    }

    public static void log(int ... params) {
        String nums = "primitives array: {";
        for (int i = 0; i < params.length; i++) {
            nums += params[i] + "";

            if (i != params.length-1) {
                nums += ", ";
            }
        }
        nums += "}";
        System.out.println(nums);

        checkIfStringIsEqualToLast(params);
        for (int temp : params) {
            checkIfIntegerComesAsSequence(temp);
        }
    }

    public static void log(byte message) {
        System.out.println(primitiveType.value + message);
        checkIfStringIsEqualToLast(message);
        checkIfIntegerComesAsSequence(message);
    }

    public static void log(char message) {
        System.out.println(charType.value + message);
        checkIfStringIsEqualToLast(message);
        checkIfIntegerComesAsSequence(message);
    }

    public static void log(String message) {
        checkIfStringIsEqualToLast(message);
        checkIfIntegerComesAsSequence(message);
    }

    public static void log(String ... params){
        checkIfIntegerComesAsSequence(params);
        for (String temp : params){
            checkIfStringIsEqualToLast(temp);
        }

    }

    public static void log(boolean message) {
        System.out.println(primitiveType.value + message);
        checkIfStringIsEqualToLast(message);
        checkIfIntegerComesAsSequence(message);
    }

    public static void log(Object message) {
        System.out.println(referenceType.value + message);
        checkIfStringIsEqualToLast(message);
        checkIfIntegerComesAsSequence(message);
    }

    private static void checkIfStringIsEqualToLast(Object message) {
        if (message instanceof String) {
            accumString = true;

            if (Objects.equals(lastStr, (String)message)) {
                strCount++;
            }
            else {
                if (strCount > 1) {
                    System.out.println(stringType.value + lastStr + " (x" + strCount + ")");
                }
                else {
                    if (lastStr != null) {
                        System.out.println(stringType.value + lastStr);
                    }
                }

                lastStr = (String)message;
                strCount = 1;
            }
        }
        else {
            if (accumString) {
                if (strCount > 1) {
                    System.out.println(stringType.value + lastStr + " (x" + strCount + ")");
                }
                else {
                    System.out.println(stringType.value + lastStr);
                }
                strCount = 1;
                accumString = false;
            }
        }
    }

    public static void checkIfIntegerComesAsSequence(Object message){
        if (message instanceof Integer) {
            if (!intAccumulateState) {
                intAccumulateState = true;
            }
            if ((long)intAccumulateSum + (long)((int)message) > (long)Integer.MAX_VALUE) {
                System.out.println(Integer.MAX_VALUE);
                intAccumulateSum = (int)((long)intAccumulateSum + (long)((int)message) - (long)Integer.MAX_VALUE);

            }
            else if ((long)intAccumulateSum + (long)((int)message) < (long)Integer.MIN_VALUE) {
                System.out.println(Integer.MIN_VALUE);
                intAccumulateSum = (int)((long)intAccumulateSum + (long)((int)message) - (long)Integer.MIN_VALUE);
            }
            else {
                intAccumulateSum += (int)message;
            }
        }
        else{
            if (intAccumulateState) {
                System.out.println(primitiveType.value + intAccumulateSum);
                intAccumulateState = false;
                intAccumulateSum = 0;
            }
        }
    }


    public static void flush(){
        checkIfStringIsEqualToLast(null);
        checkIfIntegerComesAsSequence(null);
    }
}
