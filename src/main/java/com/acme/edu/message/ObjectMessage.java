package com.acme.edu.message;

/**
 * Created by Java_1 on 24.08.2018.
 */
public class ObjectMessage implements Message {

    private Object value;
    private static final String REFERENCE = "reference: ";

    public ObjectMessage(Object message) {
        this.value = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof ObjectMessage;
    }

    @Override
    public String getDecoratedMessage(){
        return REFERENCE + value;
    }

    @Override
    public Message accumulate(Message message){
        return new ObjectMessage(((ObjectMessage) message).getValue());
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
