package com.acme.edu.logger;


/**
 * Created by Павел on 05.11.2015.
 */
public class LogException extends Exception {

    /**
     * @param message review exception
     */
    public LogException(String message) {
        super(message);
    }

    /**
     * review exception and type exception
     * @param message
     * @param cause
     */
    public LogException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Empty constrictor
     */

    public LogException() {
    }

    /**
     * Incorrect data
     * @param cause The <code>Throwable </code> be printed to the console.
     */
    public LogException(Throwable cause) {
        super(cause);
    }
}
