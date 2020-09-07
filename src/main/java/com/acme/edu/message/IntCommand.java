package com.acme.edu.message;

public class IntCommand extends LogMessage {
    static int intBuffer = 0;
    public static boolean intFlag = false;
    private int value;
    final static String
            PREFIX_PRIMITIVE = "primitive: ";

    public IntCommand (int message){
        this.value = message;
    }

    @Override
    public String getDecoratedSelf(){
        return PREFIX_PRIMITIVE + value;
    }

    @Override
    public static void reset(){
        intFlag = false;
        intBuffer = 0;
    }

    public boolean checkFlush() {
        int sumCheck = value + intBuffer;
        return sumCheck >= Integer.MAX_VALUE;
    }

}
