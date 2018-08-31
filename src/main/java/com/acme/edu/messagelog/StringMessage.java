package com.acme.edu.messagelog;

public class StringMessage extends Message<String> {
    private static final String TYPE_NAME = "string";
    private final int currentStringCount;

    private StringMessage(String message, int count) {
        this.value = message;
        type = TYPE_NAME;
        currentStringCount = count;
    }

    public StringMessage(String message){
        this(message, 1);
    }

    public int getStringCount() {
        return currentStringCount;
    }

    @Override
    public Message accumulate(Message message) {
        return new StringMessage(value, currentStringCount + 1);
    }

    @Override
    public String getFormattedMessage(LoggerDecorator decorator){
        return decorator.decorate(this);
    }

    @Override
    public boolean canBeAccumulated(Message message) {
        return super.canBeAccumulated(message) && ((StringMessage) message).value.equals(value);
    }

}
