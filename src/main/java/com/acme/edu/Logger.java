package com.acme.edu;

import java.util.Objects;

public class Logger {
    public static String PRIMITIVE_TYPE = "primitive: ";
    public static String CHAR_TYPE = "char: ";
    public static String STRING_TYPE = "string: ";
    public static String REFERENCE_TYPE = "reference: ";
    private static boolean intAccumulateState = false;
    private static int intAccumulateSum = 0;

    private static boolean accumString = false;

    private static int strCount = 1;
    private static String lastStr = null;

    public static void log(int message) {
        if (!intAccumulateState) {
            intAccumulateState = true;
        }
        intAccumulateSum += message;
        checkIfStringIsEqualToLast(message);
    }

    public static void log(byte message) {
        System.out.println(PRIMITIVE_TYPE + message);
        checkIfStringIsEqualToLast(message);
        flush();
    }

    public static void log(char message) {
        System.out.println(CHAR_TYPE + message);
        checkIfStringIsEqualToLast(message);
        flush();
    }

    public static void log(String message) {
        System.out.println(STRING_TYPE + message);
        checkIfStringIsEqualToLast(message);
    }

    public static void log(boolean message) {
        System.out.println(PRIMITIVE_TYPE + message);
        checkIfStringIsEqualToLast(message);
        flush();
    }

    public static void log(Object message) {
        System.out.println(REFERENCE_TYPE + message);
        checkIfStringIsEqualToLast(message);
        flush();
    }

    private static void checkIfStringIsEqualToLast(Object message) {
        if (message instanceof String) {
            accumString = true;

            if (Objects.equals(lastStr, (String)message)) {
                strCount++;
            }
            else {
                if (strCount > 1) {
                    System.out.println(lastStr + " (x" + strCount + ")");
                }
                else {
                    System.out.println(lastStr);
                }

                lastStr = (String)message;
                strCount = 1;
            }
        }
        else {
            if (accumString == true) {
                if (strCount > 1) {
                    System.out.println(lastStr + " (x" + strCount + ")");
                }
                else {
                    System.out.println(lastStr);
                }
                strCount = 1;
                accumString = false;
            }
        }
    }

    public static void flush(){
        if (intAccumulateState) {
            System.out.println(PRIMITIVE_TYPE + intAccumulateSum);
            intAccumulateState = false;
            intAccumulateSum = 0;
        }

        checkIfStringIsEqualToLast(null);
    }
}
