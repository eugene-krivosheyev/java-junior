package com.acme.edu;


import com.acme.edu.model.message.*;
import com.acme.edu.model.MessageContainer;


public class Logger {
    private MessageContainer container;
    private final boolean isArray;

    public Logger(boolean isArray) {
        container = new MessageContainer();
        this.isArray = isArray;
    }

    public Logger() {
        this(false);
    }

    public void log(int message) {
        container.addMessage(new IntMessageWithStringValue(String.valueOf(message)));
    }

    public void log(byte message) {
        container.addMessage(new ByteMessageWithStringValue(String.valueOf(message)));
    }

    public void log(char message) {
        container.addMessage(new CharMessageWithStringValue(String.valueOf(message)));
    }


    public void log(String message) {
        container.addMessage(new StringMessageWithStringValue(message));
    }

    public void log(boolean message) {
        container.addMessage(new BooleanMessageWithStringValue(String.valueOf(message)));
    }

    public void log(Object message) {
        container.addMessage(new ObjectMessageWithStringValue(String.valueOf(message)));
    }

    public void log(int... messages) {
        if (isArray) {
            container.addMessage(new MessageWithArrayValue(messages));
        } else {
            for (int message : messages) {
                log(message);
            }
        }
    }

    public void log(int[][] messages) {
        int[] formattedMessage = new int[messages.length * messages[0].length];
        container.addMessage(new MatrixMessage(formattedMessage));
    }

    public void log(String... messages) {
        for (String message : messages) {
            container.addMessage(new StringMessageWithConcatenation(message));
        }
    }

    public void flush() {
        System.out.print(container.getText());
        container = new MessageContainer();
    }
}
