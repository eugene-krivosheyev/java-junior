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
import com.acme.edu.message.*;

public class Logger {
    public static Controller controller = new Controller(System.out::println);


    public static void main(String[] args) {
        Logger.log("Byaka");
        Logger.flush();
    }

    public static int log(int message) {
        try {
            controller.log(new IntMessage(message, new IntDecorator()));
        } catch (LogException e) {
            return e.getCode();
        }
        return 0;
    }

    public static int log(byte message) {
        try {
            controller.log(new ByteMessage(message, new ByteDecorator()));
        } catch (LogException e) {
            return e.getCode();
        }
        return 0;
    }

    public static int log(boolean message) {
        try {
            controller.log(new BooleanMessage(message, new BooleanDecorator2()));
        } catch (LogException e) {
            return e.getCode();
        }
        return 0;
    }

    public static int log(char message) {
        try {
            controller.log(new CharMessage(message, new CharDecorator()));
        } catch (LogException e) {
            return e.getCode();
        }
        return 0;
    }

    public static int log(String message) {
        try {
            controller.log(new StringMessage(message, new StringDecorator()));
        } catch (LogException e) {
            return e.getCode();
        }
        return 0;
    }

    public static int log(Object message) {
        try {
            controller.log(new ObjectMessage(message, new ObjectDecorator()));
        } catch (LogException e) {
            return e.getCode();
        }
        return 0;
    }

    public static int log(int[] message) {
        try {
            controller.log(new ArrayMessage(message, new ArrayDecorator()));
        } catch (LogException e) {
            return e.getCode();
        }
        return 0;
    }
/*
    public static void log(int[][] message) {
        controller.log(new MatrixMessage(message));
    }
*/
    public static int flush() {
        try {
            controller.flush();
        } catch (LogException e) {
            return e.getCode();
        }
        return 0;
    }

}