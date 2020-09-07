package com.acme.edu.message;

public class BooleanCommand extends LogMessage {
    private boolean value;
    final static String
            PREFIX_PRIMITIVE = "primitive: ";

    public BooleanCommand (boolean message){
        this.value = message;
    }

    @Override
    public String getDecoratedSelf(){
        return PREFIX_PRIMITIVE + value;
    }

    public boolean checkFlush() {
        return true;
    }

    @Override
    public void reset(){}
}
