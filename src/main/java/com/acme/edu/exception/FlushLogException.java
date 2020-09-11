package com.acme.edu.exception;

/**
 * Extension of LoggerException class for raising specific error
 * when flush cannot be performed, e.g. due to empty message queue.
 * @see LoggerException
 */
public class FlushLogException extends LoggerException {
    public FlushLogException(String s, IndexOutOfBoundsException e) {
        super(s, e);
    }
}
