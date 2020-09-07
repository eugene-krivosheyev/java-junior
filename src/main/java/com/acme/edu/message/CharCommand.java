package com.acme.edu.message;

public class CharCommand extends LogMessage{
    private char value;
    final static String
            PREFIX_PRIMITIVE = "char: ";

    public CharCommand (char message){
        this.value = message;
    }

    @Override
    public String getDecoratedSelf(){
        return PREFIX_PRIMITIVE + value;
    }

    @Override
    public void reset(){}

    public boolean checkFlush() {
        return true;
    }
}
