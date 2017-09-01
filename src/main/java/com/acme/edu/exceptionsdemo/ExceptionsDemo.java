package com.acme.edu.exceptionsdemo;

public class ExceptionsDemo {
    public static void main(String[] args) {
        m();
    }

    private static void m() {
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

    private static void mm() {
        throw new RuntimeException("1");
    }
}
