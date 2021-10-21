package com.acme.edu.message.type;

import com.acme.edu.message.DataEqualMessage;
import com.acme.edu.message.Message;

public class ByteMessage extends DataEqualMessage {

    static final int MAXVALUE = Byte.MAX_VALUE;
    static final int MINVALUE = Byte.MIN_VALUE;

    public ByteMessage(byte msg, boolean isSum){
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
    public DataEqualMessage add(Message msg) {
        if (isSameType(msg)){
            if (!isMAXMIN((DataEqualMessage) msg)){
                data = ((byte)data + (byte)msg.getData());
                setEndLogging(false);
                return this;
            } else {
                DataEqualMessage tempMsg = new ByteMessage(this);
                data = (isMAX((DataEqualMessage)msg)) ? MAXVALUE : data;
                data = (isMIN((DataEqualMessage)msg)) ? MINVALUE : data;
                setEndLogging(true);
                return tempMsg;
            }
        }
        setEndLogging(false);
        return this;
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof ByteMessage;
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
    public boolean isMAXMIN(DataEqualMessage value){
        return isMAX(value); //|| (MIN - bufferInteger > value);
    }

    @Override
    public boolean isMAX(DataEqualMessage value) {
        return (MAXVALUE - (byte)data < (byte)value.getData());
    }

    @Override
    public boolean isMIN(DataEqualMessage value) {
        return super.isMIN(value);
    }

    @Override
    public String prefix() {
        return "primitive: ";
    }
}
