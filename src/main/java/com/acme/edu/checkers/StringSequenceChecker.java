package com.acme.edu.checkers;


import com.acme.edu.Type;

import java.util.Objects;

public class StringSequenceChecker extends Checker{

    private static boolean accumString = false;
    private static int strCount = 1;
    private static String lastStr = null;

    public void check(Object message) {
        if (message instanceof String) {
            accumString = true;

            if (Objects.equals(lastStr, message)) {
                strCount++;
            }
            else {
                if (strCount > 1) {
                    System.out.println(Type.STRING.value + lastStr + " (x" + strCount + ")");
                }
                else {
                    if (lastStr != null) {
                        System.out.println(Type.STRING.value + lastStr);
                    }
                }

                lastStr = (String)message;
                strCount = 1;
            }
        }
        else {
            if (accumString) {
                if (strCount > 1) {
                    System.out.println(Type.STRING.value + lastStr + " (x" + strCount + ")");
                }
                else {
                    System.out.println(Type.STRING.value + lastStr);
                }
                strCount = 1;
                accumString = false;
            }
        }
    }
}
