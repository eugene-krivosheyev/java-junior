package com.acme.edu.message;

import static java.lang.System.lineSeparator;

public abstract class Message {

    protected static final String SEP = lineSeparator();

    protected Object data;
    private boolean isSumming = false;
    private boolean isEndLogging = false;
    public Object getData() {
        return data;
    }

    public boolean isEmpty(){
        return this instanceof EmptyMessage;
    }
    public boolean isEndLogging() {
        return isEndLogging;
    }
    public boolean isSum(){return isSumming;}
    public boolean isSame(Message message){
        return this.isSameType(message) && (this.data.equals(message.data));
    }
    public abstract boolean isSameType(Message message);

    public abstract void setMsg(Object message);

    public abstract void setMsg(Object message, boolean isSum);

    public abstract Message add(Message message);

    public void setEndLogging(boolean isEnd) {
        isEndLogging = isEnd;
    }

    public abstract String toString();

    public boolean isMAXMIN(Message value){return false;}
    public boolean isMAX(Message value){return false;}
    public boolean isMIN(Message value){return false;}

    public abstract String prefix();

}
