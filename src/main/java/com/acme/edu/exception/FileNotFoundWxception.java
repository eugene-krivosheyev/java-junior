package com.acme.edu.exception;

public class FileNotFoundWxception extends SaveOperationException {
    public FileNotFoundWxception(SaveOperationException e) {
        super(e);
    }
}
