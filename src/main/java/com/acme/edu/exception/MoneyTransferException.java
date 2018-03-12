package com.acme.edu.exception;

public class MoneyTransferException extends RuntimeException {
    public MoneyTransferException() {
        super();
    }

    public MoneyTransferException(String message) {
        super(message);
    }

    public MoneyTransferException(String message, Throwable cause) {
        super(message, cause);
    }

    public MoneyTransferException(Throwable cause) {
        super(cause);
    }
}
