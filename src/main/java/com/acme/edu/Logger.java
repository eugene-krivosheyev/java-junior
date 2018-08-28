package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.message.decorator.*;

public class Logger {
    public static void flush() {
        controller.log(new FlushMessage(), emptyDecorator);
    }

    public static void log(int message) {
        controller.log(new IntMessage(message), intDecorator);
    }

    public static void log(int[] message) {
        controller.log(new IntArrayMessage(message), intArrayDecorator);
    }

    public static void log(int[][] message) {
        controller.log(new IntMatrixMessage(message), intMatrixDecorator);
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message), byteDecorator);
    }

    public static void log(char message) {
        controller.log(new CharMessage(message), charDecorator);
    }

    public static void log(String message) {
        controller.log(new StringMessage(message), stringDecorator);
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message), booleanDecorator);
    }

    public static void log(Object message) {
        controller.log(new ReferenceMessage(message), referenceDecorator);
    }

    public static void setDecorator(MessageType messageType, Decorator newDecorator) {
        switch (messageType) {
            case BOOLEAN:
                booleanDecorator = newDecorator;
                break;
            case BYTE:
                byteDecorator = newDecorator;
                break;
            case INT:
                intDecorator = newDecorator;
                break;
            case CHAR:
                charDecorator = newDecorator;
                break;
            case STRING:
                stringDecorator = newDecorator;
                break;
            case OBJECT:
                referenceDecorator = newDecorator;
                break;
            case INTARRAY:
                intArrayDecorator = newDecorator;
                break;
            case INTMATRIX:
                intMatrixDecorator = newDecorator;
                break;
        }
    }

    private static Controller controller = new Controller();

    private static Decorator booleanDecorator = new DefaultBooleanDecorator();
    private static Decorator byteDecorator = new DefaultByteDecorator();
    private static Decorator charDecorator = new DefaultCharDecorator();
    private static Decorator emptyDecorator = new EmptyDecorator();
    private static Decorator intDecorator = new DefaultIntDecorator();
    private static Decorator intArrayDecorator = new DefaultIntArrayDecorator();
    private static Decorator intMatrixDecorator = new DefaultIntMatrixDecorator();
    private static Decorator referenceDecorator = new DefaultReferenceDecorator();
    private static Decorator stringDecorator = new DefaultStringDecorator();
}
