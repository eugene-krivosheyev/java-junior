package com.acme.edu;

public class IllegalStringToPrintExeption extends Exception {

    public IllegalStringToPrintExeption(String message) {
        super(message);
    }

    public IllegalStringToPrintExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
