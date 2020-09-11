package com.acme.edu.exception;

/**
 * Extension of LoggerException class for raising specific error
 * when log saving cannot be performed, e.g. due to incorrect file path.
 * @see LoggerException
 */
public class SaveException extends LoggerException {
    public SaveException(String s, Exception e) {
        super(s, e);
    }
}
