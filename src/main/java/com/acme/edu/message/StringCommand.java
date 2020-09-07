package com.acme.edu.message;

public class StringCommand extends LogMessage {
    static String strBuffer = "";
    private static int strCounter = 0;
    public static boolean strFlag = false;
    private String value;
    final static String
            PREFIX_PRIMITIVE = "string: ";

    public StringCommand (String message){
        strCounter = 1;
        this.value = message;
    }

    @Override
    public String getDecoratedSelf(){
        if (strCounter > 1)
            return PREFIX_PRIMITIVE + value + " (x" + strCounter + ")";
        return PREFIX_PRIMITIVE + value;
    }

    @Override
    public void reset(){
        strFlag = false;
        strBuffer = "";
        strCounter = 0;
    }

    public boolean checkFlush() {
        return !value.equals(strBuffer);
    }
}
