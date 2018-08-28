package com.acme.edu.decorator;

import com.acme.edu.messagelog.*;

public class TypeLoggerDecorator implements LoggerDecorator {
    private static final String FORMAT_STRING = "This is %s";

    @Override
    public String decorate (IntMessage message){
        return getFormattedString(message.getType());
    }

    @Override
    public String decorate (ByteMessage message){
        return getFormattedString(message.getType());
    }

    @Override
    public String decorate (CharMessage message){
        return getFormattedString(message.getType());
    }

    @Override
    public String decorate (ArrayIntMessage message) {
        return getFormattedString(message.getType());
    }

    @Override
    public String decorate(BooleanMessage message) {
        return getFormattedString(message.getType());
    }

    @Override
    public String decorate(MatrixIntMessage message) {
        return getFormattedString(message.getType());
    }

    @Override
    public String decorate(ObjectMessage message) {
        return getFormattedString( message.getType());
    }

    @Override
    public String decorate(StringMessage message) {
        return getFormattedString(message.getType());
    }

    private String getFormattedString(String type) {
        return String.format(FORMAT_STRING, type);
    }
}
