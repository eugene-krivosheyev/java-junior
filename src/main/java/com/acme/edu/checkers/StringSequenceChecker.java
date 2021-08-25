package com.acme.edu.checkers;

import com.acme.edu.Type;

import java.util.Objects;

public class StringSequenceChecker extends Checker{
    public static Type primitiveType = Type.PRIMITIVE;
    public static Type charType = Type.CHAR;
    public static Type stringType = Type.STRING;
    public static Type referenceType = Type.REFERENCE;

    private static boolean accumString = false;
    private static int strCount = 1;
    private static String lastStr = null;

    public static void check(Object message) {
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
}
