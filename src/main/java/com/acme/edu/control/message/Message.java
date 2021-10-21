package com.acme.edu.control.message;

import java.util.Objects;

import static java.lang.System.lineSeparator;

public abstract class Message {
     public enum  msgType {
        INT,
        BYTE,
        STRING,
        CHAR,
        BOOL,
        OBJECT,
        AINT,
        ASTRING,
        EMPTY
    }

    public static final String sep = lineSeparator();

    protected msgType type;
    protected int dim;
    protected Object  data;
    protected boolean isSumming = false;
    protected boolean isEndLogging = false;

    public msgType getType() {
        return type;
    }

    public Object getData() {
        return data;
    }
    public boolean isSum(){return isSumming;}

    public abstract void setMsg(Object message);

    public abstract void setMsg(Object message, boolean isSum);
    public abstract Message add(Message message);

    public boolean isSameType(Message message){
        return (this.type.equals(message.type));
    }

    public boolean isSame(Message message){
        return isSameType(message) && (this.data.equals(message.data));
    }

    public boolean isType(msgType type){
        return (this.type.equals(type));
    }

    public boolean isEmpty(){
        return this.isType(Message.msgType.EMPTY);
    }

    public void setEndLogging(boolean isEnd) {
        isEndLogging = isEnd;
    }
    public boolean isEndLogging() {
        return isEndLogging;
    }

    public abstract String toString();

    public boolean isMAXMIN(Message value){return false;}
    public boolean isMAX(Message value){return false;}
    public boolean isMIN(Message value){return false;}

    protected String prefix(){
        switch (this.type){
            case STRING :{ return "string: ";   }
            case CHAR   :{ return "char: ";     }
            case OBJECT :{ return "reference: ";}
            case ASTRING:{ return "";           }
            case INT    :
            case BYTE   :
            case BOOL   :
            case AINT   :{
                String extra = "";
                if (Objects.equals(msgType.AINT,this.type)) {
                    switch (dim){
                        case 1:{ extra = "s array";      }break;
                        case 2:{ extra = "s matrix";     }break;
                        case 3:{ extra = "s cube";       }break;
                        case 4:{ extra = "s multimatrix";}break;
                    }
                }
                return String.format("primitive%s: ",extra);
            }
        }
        return "";
    }
}
