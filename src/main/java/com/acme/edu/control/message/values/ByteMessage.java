package com.acme.edu.control.message.values;

import com.acme.edu.control.message.Message;

public class ByteMessage extends Message {

    static final int MAXVALUE = Byte.MAX_VALUE;
    static final int MINVALUE = Byte.MIN_VALUE;

    public ByteMessage(byte msg, boolean isSum){
        type = msgType.BYTE;
        setMsg(msg,isSum);
    }

    public ByteMessage(ByteMessage message){
        this((byte) message.getData(), message.isSum());
    }

    public ByteMessage(byte msg){
        this(msg,false);
    }
    @Override
    public void setMsg(Object message) {
        data = message;
    }

    @Override
    public void setMsg(Object message, boolean isSum) {
        setMsg(message);
        isSumming = isSum;
    }

    @Override
    public Message add(Message msg) {
        if (isSameType(msg)){
            if (!isMAXMIN(msg)){
                data = ((byte)data + (byte)msg.getData());
                setEndLogging(false);
                return this;
            } else {
                Message tempMsg = new ByteMessage(this);
                data = (isMAX(msg))?MAXVALUE:data;
                data = (isMIN(msg))?MINVALUE:data;
                setEndLogging(true);
                return tempMsg;
            }
        }
        setEndLogging(false);
        return this;
    }

    @Override
    public String toString() {
        if (isSumming){
           return String.valueOf(data);
        } else {
            return prefix() + (byte) data;
        }
    }

    @Override
    public boolean isMAXMIN(Message value){
        return isMAX(value); //|| (MIN - bufferInteger > value);
    }

    @Override
    public boolean isMAX(Message value) {
        return (MAXVALUE - (byte)data < (byte)value.getData());
    }

    @Override
    public boolean isMIN(Message value) {
        return super.isMIN(value);
    }
}
