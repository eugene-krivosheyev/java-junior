package com.acme.edu;

import com.acme.edu.Logger.LoggingType;

public class Command {




    private final static String PREFIX_PRIMITIVES_ARRAY = "primitives array: ";

    //region TYPES
    private int[] arrayToLog;
    private String stringToLog;
    private char charToLog;
    private boolean boolToLog;

    private byte byteToLog;
    private int integerToLog;
    //endregion

    private LoggingType type;
    private LongAccumulator accumulator = null;


    public Command(int[] message) {
        this.arrayToLog = message;
        type = LoggingType.INTARRAY;
    }
    public Command(String message) {
        this.stringToLog = message;
        type = LoggingType.STRING;
    }
    public Command(char message) {
        this.charToLog = message;
        type = LoggingType.CHAR;
    }
    public Command(boolean message) {
        this.boolToLog = message;
        type = LoggingType.BOOLEAN;
    }
    public Command(byte message) {
        byteToLog = message;
        type = LoggingType.BYTE;
    }
    public Command(int message) {
        integerToLog = message;
        type = LoggingType.INT;
    }


    public String decorate() {
        if(type == LoggingType.INTARRAY) {
            return PREFIX_PRIMITIVES_ARRAY + intArrayToString();
        }
        return "";
    }


    private String intArrayToString() {
        String res = "{";
        for(int i = 0; i < arrayToLog.length; ++i) {
            res += Integer.toString(arrayToLog[i]);
            if (i < arrayToLog.length - 1) {
                res += ", ";
            }
        }
        return res + "}";
    }

}
