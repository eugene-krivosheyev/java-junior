package com.acme.edu.exception;

public class SaveOperationException extends Exception {
    public SaveOperationException(SaveOperationException e) {
        super(e);
    }
}
