package com.acme.edu.message;

import static java.lang.System.lineSeparator;

public abstract class DataEqualMessage implements Message {

    protected static final String SEP = lineSeparator();

    protected Object data;
    protected boolean isSumming = false;
    protected boolean isEndLogging = false;
    @Override
    public Object getData() {
        return data;
    }

    @Override
    public boolean isEmpty(){
        return this instanceof EmptyMessage;
    }
    @Override
    public boolean isEndLogging() {
        return isEndLogging;
    }
    @Override
    public boolean isSum(){return isSumming;}
    public boolean isSame(DataEqualMessage message){
        return this.isSameType(message) && (this.data.equals(message.data));
    }

    @Override
    public void setEndLogging(boolean isEnd) {
        isEndLogging = isEnd;
    }

    public abstract String toString();

    public boolean isMAXMIN(DataEqualMessage value){return false;}
    public boolean isMAX(DataEqualMessage value){return false;}
    public boolean isMIN(DataEqualMessage value){return false;}

}
