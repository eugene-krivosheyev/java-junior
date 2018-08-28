package com.acme.edu.message.decorator;

import com.acme.edu.message.ArrayIntMessage;
import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.CharMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.BooleanMessage;
import com.acme.edu.message.MatrixIntMessage;
import com.acme.edu.message.ObjectMessage;
import com.acme.edu.message.StringMessage;

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
