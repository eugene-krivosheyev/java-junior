package com.acme.edu.logger2;

import com.acme.edu.logger2.core.controller.LoggerController;
import com.acme.edu.logger2.core.message.*;

/**
 * Class that logs different types of data
 * by proceeding them threw loggerController
 */

public class Logger2 {
    private static final LoggerController loggerController = new LoggerController();


    //region log method overloads
    /**
     * Method that sends an int value to LoggerController
     * @param message int value to log
     */
    public static void log(int message) {
        loggerController.proceedMessage(new IntMessage(message));
    }

    /**
     * Method that sends a byte value to LoggerController
     * @param message byte value to log
     */
    public static void log(byte message) {
        loggerController.proceedMessage(new ByteMessage(message));
    }

    /**
     * Method that sends a char to LoggerController
     * @param message char value to log
     */
    public static void log(char message) {
        loggerController.proceedMessage(new CharMessage(message));
    }

    /**
     * Method that sends a String to LoggerController
     * @param message String to log
     */
    public static void log(String message) {
        loggerController.proceedMessage(new StringMessage(message));
    }

    /**
     * Method that sends a boolean value to LoggerController
     * @param message boolean value to log
     */
    public static void log(boolean message) {
        loggerController.proceedMessage(new BooleanMessage(message));
    }

    /**
     * Method that sends an Object to LoggerController
     * @param message Object to log
     */
    public static void log(Object message) {
        loggerController.proceedMessage(new ObjectReferenceMessage(message));
    }

    /**
     * Method that sends an int array to LoggerController
     * @param array int array to log
     */
    public static void log(int... array) {
        loggerController.proceedMessage(new IntArrayMessage(array));
    }
    //endregion

    /**
     * Message that stops logger
     */
    public static void stop() {
        loggerController.stop();
    }
}
