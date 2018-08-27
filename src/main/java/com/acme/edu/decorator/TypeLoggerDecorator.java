package com.acme.edu.decorator;

import com.acme.edu.message.*;

public class TypeLoggerDecorator implements LoggerDecorator {
    private static final String FORMAT_STRING = "This is %s";

    public String decorate (IntMessage message){
        return getFormattedString(message.getType());
    }

    public String decorate (ByteMessage message){
        return getFormattedString(message.getType());
    }

    public String decorate (CharMessage message){
        return getFormattedString(message.getType());
    }

    public String decorate (ArrayIntMessage message) {
        return getFormattedString(message.getType());
    }

    public String decorate(BooleanMessage message) {
        return getFormattedString(message.getType());
    }

    public String decorate(MatrixIntMessage message) {
        return getFormattedString(message.getType());
    }

    public String decorate(ObjectMessage message) {
        return getFormattedString( message.getType());
    }

    public String decorate(StringMessage message) {
        return getFormattedString(message.getType());
    }

    private String getFormattedString(String type) {
        return String.format(FORMAT_STRING, type);
    }
}
