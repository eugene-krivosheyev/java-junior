package com.acme.edu.exception;

import java.io.IOException;

public class ExceptionDemo {
    public static void main(String... args) {
        //
        try {
            moneyTransfer();
        } catch (MoneyTransferException | IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            //Global Super Handler
            e.printStackTrace();
            //request fail
        }
        //
    }

    public static void moneyTransfer() throws MoneyTransferException {
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
            throw new MoneyTransferException("MTE", e);
        }
    }

    private static void save() throws IOException {
        //
        throw new IOException("file: xxx");
        //
    }
}

class MoneyTransferException extends Exception {
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

    protected MoneyTransferException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}