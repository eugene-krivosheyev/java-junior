package com.acme.edu.decorator;

import com.acme.edu.messagelog.*;

import java.util.Arrays;

public class PrefixLoggerDecorator implements LoggerDecorator {
    private static final String FORMAT_STRING = "%s: %s";

    @Override
    public String decorate (IntMessage message){
        return getFormattedString(String.valueOf(message.getValue()), message.getType());
    }

    @Override
    public String decorate (ByteMessage message){
        return getFormattedString(String.valueOf(message.getValue()), message.getType());
    }

    @Override
    public String decorate (CharMessage message){
        return getFormattedString(String.valueOf(message.getValue()), message.getType());
    }

    @Override
    public String decorate (ArrayIntMessage message) {
        return getFormattedString(formatArray(message.getValue()), message.getType());
    }

    @Override
    public String decorate(BooleanMessage message) {
        return getFormattedString(String.valueOf(message.getValue()), message.getType());
    }

    @Override
    public String decorate(MatrixIntMessage message) {
        StringBuilder arrayStringBuilder = new StringBuilder();
        arrayStringBuilder
                .append('{')
                .append(System.lineSeparator());
        for (int[] arr : message.getValue()) {
            arrayStringBuilder
                    .append(formatArray(arr))
                    .append(System.lineSeparator());
        }
        arrayStringBuilder
                .append('}');
        return  getFormattedString(arrayStringBuilder.toString(), message.getType());
    }

    @Override
    public String decorate(ObjectMessage message) {
        return getFormattedString(message.getValue().toString(), message.getType());
    }

    @Override
    public String decorate(StringMessage message) {
        int currentStringCount = message.getStringCount();
        String postfixForRepeatedStrings = (currentStringCount > 1) ? String.format(" (x%d)", currentStringCount) : "";
        return getFormattedString(message.getValue(), message.getType()) + postfixForRepeatedStrings;
    }

    protected String getFormattedString(String convertedMessage, String type) {
        return String.format(FORMAT_STRING, type, convertedMessage);
    }

    protected String formatArray(int[] array) {
        return Arrays.toString(array)
                .replace('[', '{')
                .replace(']', '}');
    }
}
