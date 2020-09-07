package com.acme.edu.message;

public class ReferenceCommand extends LogMessage {
    private Object value;
    final static String
            PREFIX_PRIMITIVE = "reference: ";

    public ReferenceCommand (Object message){
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
