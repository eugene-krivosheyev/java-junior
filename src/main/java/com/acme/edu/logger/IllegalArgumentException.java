package com.acme.edu.logger;

/**
 * Created by Павел on 05.11.2015.
 */
public class IllegalArgumentException extends LogException {

    /**
     * An exception is thrown if the message is empty or null
     * @param message
     */
    public IllegalArgumentException(String message) {
        super(message);
    }
}
