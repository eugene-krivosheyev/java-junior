package com.acme.edu;

import com.acme.edu.message.*;

public class Controller {

//    private IntegerMessage integerMessage;
//    private ByteMessage byteMessage;
//    private CharacterMessage characterMessage;
//    private StringMessage stringMessage;
//    private BooleanMessage booleanMessage;
//    private ObjectMessage objectMessage;
    private Integer intAccum;
    private Message type;

    public void log(Message message) {
        message.getStrategy()
    }

   /* public void log(Integer message) {
        if (integerMessage == null) {
            integerMessage = new IntegerMessage(message);
            type = Type.INTEGER;
        } else {
            if (type == Type.INTEGER) {
                integerMessage.accumulate(message);
            } else {
                flush();
            }
        }
    }

    public void log(Byte message) {
        if (byteMessage == null) {
            byteMessage = new ByteMessage(message);
            type = Type.BYTE;
        } else {
            if (type == Type.BYTE) {
                byteMessage.accumulate(message);
            } else {
                flush();
            }
        }
    }

    public void log(char message) {

    }

    public void log(String message) {
        if (stringMessage == null) {
            stringMessage = new StringMessage(message);
        } else {
            if (type == Type.STRING) {
                if (stringMessage.getBody().equals(message)) {
                    stringMessage.incrementCounter();
                } else {
                    flush();
                }
            } else {
                flush();
            }
        }
    }

    public void log(boolean message) {

    }

    public void log(Object message) {

    }*/

    public void flush() {
        switch (type) {
            case INTEGER:
                System.out.println(integerMessage.toString());
                integerMessage.setValue(0);
                break;
            case BYTE:
                System.out.println(byteMessage.toString());
                byteMessage.setValue((byte) 0);
                break;
        }
    }

/*    enum Type {
        INTEGER,
        BYTE,
        STRING,
        CHARACTER,
        OBJECT,
        BOOLEAN,
        INTARRAY,
        INT2DARRAY;
    }*/
}
