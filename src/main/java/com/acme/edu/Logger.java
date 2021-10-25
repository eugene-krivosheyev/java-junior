package com.acme.edu;


import com.acme.edu.model.message.*;
import com.acme.edu.model.MessageContainer;


public class Logger {
    private static MessageContainer container;

    public Logger() {
        container = new MessageContainer();
    }

    public static void log(int message) {
        container.addMessage(new IntMessage(message));
    }

    public static void log(byte message) {
        container.addMessage(new ByteMessage(message));
    }

    public static void log(char message) {
        container.addMessage(new CharMessage(message));
    }


    public static void log(String message) {
        container.addMessage(new StringMessage(message));
    }

    public static void log(boolean message) {
        container.addMessage(new BooleanMessage(message));
    }

    public static void log(Object message) {
        container.addMessage(new ObjectMessage(String.valueOf(message)));
    }

    public static void log(int... messages) {
            container.addMessage(new ArrayMessage(messages));
    }

    public static void log(int[][] messages) {
        int[] formattedMessage = new int[messages.length * messages[0].length];
        container.addMessage(new MatrixMessage(formattedMessage));
    }

    public static void log(String... messages) {
        for (String message : messages) {
            container.addMessage(new StringMessageWithConcatenation(message));
        }
    }

    public static void flush() {
        System.out.print(container.getText());
        container = new MessageContainer();
    }
}
