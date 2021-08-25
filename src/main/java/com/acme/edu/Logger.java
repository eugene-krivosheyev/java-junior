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



    public static void log(int message) {
        stringChecker.check(message);
        intCheker.check(message);
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
            intCheker.check(temp);
        }
    }

    public static void log(byte message) {
        System.out.println(primitiveType.value + message);
        stringChecker.check(message);
        intCheker.check(message);
    }

    public static void log(char message) {
        System.out.println(charType.value + message);
        stringChecker.check(message);
        intCheker.check(message);
    }

    public static void log(String message) {
        stringChecker.check(message);
        intCheker.check(message);
    }

    public static void log(String ... params){
        intCheker.check(params);
        for (String temp : params){
            stringChecker.check(temp);
        }

    }

    public static void log(boolean message) {
        System.out.println(primitiveType.value + message);
        stringChecker.check(message);
        intCheker.check(message);
    }

    public static void log(Object message) {
        System.out.println(referenceType.value + message);
        stringChecker.check(message);
        intCheker.check(message);
    }



    public static void flush(){
//        checkIfStringIsEqualToLast(null);
        stringChecker.check(null);
        intCheker.check(null);
    }
}
