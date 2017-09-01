package com.acme.edu.exceptionsdemo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsDemo {
    public static void main(String[] args) throws Exception {
        m();
    }

    private static void m() throws Exception {
        RuntimeException runtimeException = null;
        try {
            mm();
        } catch (RuntimeException e) {
            runtimeException = new RuntimeException("2", e);
            throw runtimeException;
        } finally {
            if (runtimeException != null) {
                RuntimeException finallyExc = new RuntimeException("3");
                finallyExc.addSuppressed(runtimeException);
                throw finallyExc;
            }
        }
    }

    private static void mm() throws Exception {
        throw new Exception("1");
    }
}


interface Saver {
    void save() throws SavingException;
}

class FileSaver implements Saver {
    @Override
    public void save() throws SavingException {
        try {
            throw new FileNotFoundException("file.txt");
        } catch (FileNotFoundException e) {
            throw new SavingException(e); //Re-throw
        }
    }
}

class SavingException extends Exception {
    public SavingException() {
        super();
    }

    public SavingException(String message) {
        super(message);
    }

    public SavingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SavingException(Throwable cause) {
        super(cause);
    }

    protected SavingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}










