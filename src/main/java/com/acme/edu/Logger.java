package com.acme.edu;

import com.acme.edu.controller.Controller;
import com.acme.edu.decorator.Decorator;
import com.acme.edu.message.*;

/**
 * The Logger class provides functions to save messages of different data types.
 * It also provides option to change saving mechanism
 */
public class Logger {
    /**
     * Forces controller to save all its buffer.
     * @return error code: 0 for success
     */
    public static int flush() {
        return controller.log(new FlushMessage());
    }

    /**
     * Save int message to logger
     * @return error code: 0 for success
     */
    public static int log(int message) {
        return controller.log(new IntMessage(message));
    }

    /**
     * Save int[] message to logger
     * @return error code: 0 for success
     */
    public static int log(int[] message) {
        return controller.log(new IntArrayMessage(message));
    }

    /**
     * Save int[][] message to logger
     * @return error code: 0 for success
     */
    public static int log(int[][] message) {
        return controller.log(new IntMatrixMessage(message));
    }

    /**
     * Save byte message to logger
     * @return error code: 0 for success
     */
    public static int log(byte message) {
        return controller.log(new ByteMessage(message));
    }

    /**
     * Save char message to logger
     * @return error code: 0 for success
     */
    public static int log(char message) {
        return controller.log(new CharMessage(message));
    }

    /**
     * Save string message to logger
     * @return error code: 0 for success
     */
    public static int log(String message) {
        return controller.log(new StringMessage(message));
    }

    /**
     * Save boolean message to logger
     * @return error code: 0 for success
     */
    public static int log(boolean message) {
        return controller.log(new BooleanMessage(message));
    }

    /**
     * Save Object message to logger
     * @return error code: 0 for success
     */
    public static int log(Object message) {
        return controller.log(new ReferenceMessage(message));
    }

    /**
     * change decorator or specific type
     * @param type: type of messages for which associated decorator should be changed
     * @param newDecorator: decorator object or lambda which can be cast to Decorator interface, not null
     * @return error code: 0 for success, 1 if decorator passed is null
     */
    public static int setDecorator(MessageType type, Decorator newDecorator) {
        return controller.update(type, newDecorator);
    }

    private static Controller controller = new Controller(System.out::println);
}