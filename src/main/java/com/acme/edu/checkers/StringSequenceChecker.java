package com.acme.edu.checkers;


import com.acme.edu.Type;
import com.acme.edu.savers.Saver;

import java.util.Objects;

public class StringSequenceChecker extends Checker {
    private Saver saver;

    private boolean accumString;
    private int strCount;
    private String lastStr;

    public StringSequenceChecker(Saver saver) {
        this.saver = saver;
        this.accumString = false;
        this.strCount = 1;
        this.lastStr = null;
    }


    public void check(Object message) {
        if (message instanceof String) {
            accumString = true;

            if (Objects.equals(lastStr, message)) {
                strCount++;
            }
            else {
                if (strCount > 1) {
                    saver.save(Type.STRING.value + lastStr + " (x" + strCount + ")");
                }
                else {
                    if (lastStr != null) {
                        saver.save(Type.STRING.value + lastStr);

                    }
                }

                lastStr = (String)message;
                strCount = 1;
            }
        }
        else {
            if (accumString) {
                if (strCount > 1) {
                    saver.save(Type.STRING.value + lastStr + " (x" + strCount + ")");
                }
                else {
                    saver.save(Type.STRING.value + lastStr);
                }
                strCount = 1;
                accumString = false;
            }
        }
    }
}
