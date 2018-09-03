package com.acme.edu.message;

/**
 * Created by Java_1 on 24.08.2018.
 */
public class ByteMessage implements Message {

    private byte value;

    public static final String PRIMITIVE = "primitive: ";

    public ByteMessage(byte message) {
        this.value = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof ByteMessage;
    }

    @Override
    public String getDecoratedMessage(){
        return PRIMITIVE + value;
    }

    @Override
    public void accumulate(Message message){
        byte value = ((ByteMessage) message).getValue();
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }
}