package com.acme.edu.checkers;


import com.acme.edu.Type;
import com.acme.edu.savers.Saver;

import java.util.Objects;

public class StringSequenceChecker extends Checker<String> {
    private boolean accumString;
    private int strCount;
    private String lastStr;

    public StringSequenceChecker(Saver saver) {
        this.saver = saver;
        this.accumString = false;
        this.strCount = 1;
        this.lastStr = null;
    }


    public String check(Object message) {
        String resultStr = "";

        if (message instanceof String) {
            accumString = true;

            if (Objects.equals(lastStr, message)) {
                strCount++;
                return null;
            }
            else {
                if (strCount > 1) {
                    resultStr = lastStr + " (x" + strCount + ")";
                }
                else {
                    if (lastStr != null) {
                        resultStr = lastStr;
                    }
                }

                lastStr = (String)message;
                strCount = 1;
            }
        }
        else {
            if (accumString) {
                if (strCount > 1) {
                    resultStr = lastStr + " (x" + strCount + ")";
                }
                else {
                    resultStr = lastStr;
                }
                strCount = 1;
                accumString = false;
                lastStr = null;
            }
        }

        return resultStr;
    }
}
