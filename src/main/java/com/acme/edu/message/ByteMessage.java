package com.acme.edu.message;

/**
 * Created by Java_1 on 24.08.2018.
 */
public class ByteMessage implements Message {

    private byte message;
    private static byte sum = 0;

    public static final String PRIMITIVE = "primitive: ";

    public ByteMessage(byte message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof ByteMessage;
    }

    @Override
    public String getDecoratedMessage(){
        return PRIMITIVE + message;
    }

    @Override
    public Message accumulate(Message message){
        byte value = ((ByteMessage) message).getMessage();
        sum = (byte)(sum + value);
        return new ByteMessage((byte)(sum));
    }

    public byte getMessage() {
        return message;
    }
}