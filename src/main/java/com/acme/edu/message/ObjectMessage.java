package com.acme.edu.message;

/**
 * Created by Java_1 on 24.08.2018.
 */
public class ObjectMessage implements Message {

    private Object message;
    private static final String REFERENCE = "reference: ";

    public ObjectMessage(Object message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof ObjectMessage;
    }

    @Override
    public String getDecoratedMessage(){
        return REFERENCE + message;
    }

    @Override
    public Message accumulate(Message message){
        return new ObjectMessage(((ObjectMessage) message).getMessage());
    }

    public Object getMessage() {
        return message;
    }
}
