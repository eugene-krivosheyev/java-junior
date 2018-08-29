package com.acme.edu;

/*
//TODO To think
public class Logger {

    public static void log(int[][] message) {
        Logger.flushAndChangeType(PRIMITIVE_MATRIX);
        bufferForFlush = loggerMessageType + LINE_SEPARATOR + "{" + System.lineSeparator();
        for (int outerCurrent = 0; outerCurrent < message.length; outerCurrent++) {
            addArrayToBuffer(message[outerCurrent]);
            bufferForFlush += System.lineSeparator();
        }
        bufferForFlush += "}";
    }

    public static void addArrayToBuffer(int[] message) {
        bufferForFlush += "{";
        for (int current = 0; current < message.length-1; current++) {
            bufferForFlush += message[current] + ", ";
        }
        if (message.length > 0) {
            bufferForFlush += message[message.length-1];
        }
        bufferForFlush += "}";
    }
}
*/

import com.acme.edu.decorators.*;

public class Logger {
    public static Controller controller = new Controller(System.out::println);


    public static void main(String[] args) {
        Logger.log("Byaka");
        Logger.flush();
    }

    public static void log(int message) {
        controller.log(new IntMessage(message, new IntDecorator()));
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message, new ByteDecorator()));
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message, new BooleanDecorator2()));
    }

    public static void log(char message) {
        controller.log(new CharMessage(message, new CharDecorator()));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message, new StringDecorator()));
    }

    public static void log(Object message) {
        controller.log(new ObjectMessage(message, new ObjectDecorator()));
    }

    public static void log(int[] message) {
        controller.log(new ArrayMessage(message, new ArrayDecorator()));
    }
/*
    public static void log(int[][] message) {
        controller.log(new MatrixMessage(message));
    }
*/
    public static void flush() {
        controller.flush();
    }

}