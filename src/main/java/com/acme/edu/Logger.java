package com.acme.edu;

import java.util.Objects;

import com.acme.edu.checkers.IntSequenceChecker;
import com.acme.edu.checkers.StringSequenceChecker;

public class Logger {
    public static Type primitiveType = Type.PRIMITIVE;
    public static Type charType = Type.CHAR;
    public static Type stringType = Type.STRING;
    public static Type referenceType = Type.REFERENCE;

    private static IntSequenceChecker intCheker= new IntSequenceChecker();
    private static StringSequenceChecker stringChecker = new StringSequenceChecker();

    private static boolean intAccumulateState = false;
    private static int intAccumulateSum = 0;

    public static void log(int message) {
        stringChecker.check(message);
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

        stringChecker.check(params);
        for (int temp : params) {
            checkIfIntegerComesAsSequence(temp);
        }
    }

    public static void log(byte message) {
        System.out.println(primitiveType.value + message);
        stringChecker.check(message);
        checkIfIntegerComesAsSequence(message);
    }

    public static void log(char message) {
        System.out.println(charType.value + message);
        stringChecker.check(message);
        checkIfIntegerComesAsSequence(message);
    }

    public static void log(String message) {
        stringChecker.check(message);
        checkIfIntegerComesAsSequence(message);
    }

    public static void log(String ... params){
        checkIfIntegerComesAsSequence(params);
        for (String temp : params){
            stringChecker.check(temp);
        }

    }

    public static void log(boolean message) {
        System.out.println(primitiveType.value + message);
        stringChecker.check(message);
        checkIfIntegerComesAsSequence(message);
    }

    public static void log(Object message) {
        System.out.println(referenceType.value + message);
        stringChecker.check(message);
        checkIfIntegerComesAsSequence(message);
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
//        checkIfStringIsEqualToLast(null);
        stringChecker.check(null);
        checkIfIntegerComesAsSequence(null);
    }
}
