package com.acme.edu;


import com.acme.edu.model.message.*;
import com.acme.edu.model.MessageContainer;


public class Logger {
    private MessageContainer container;

    public Logger() {
        container = new MessageContainer();
    }

    public void log(int message) {
        container.addMessage(new IntMessage(message));
    }

    public void log(byte message) {
        container.addMessage(new ByteMessage(message));
    }

    public void log(char message) {
        container.addMessage(new CharMessage(message));
    }


    public void log(String message) {
        container.addMessage(new StringMessage(message));
    }

    public void log(boolean message) {
        container.addMessage(new BooleanMessage(message));
    }

    public void log(Object message) {
        container.addMessage(new ObjectMessage(String.valueOf(message)));
    }

    public void log(int... messages) {
            container.addMessage(new ArrayMessage(messages));
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
