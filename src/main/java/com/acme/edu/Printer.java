package com.acme.edu;

public class Printer {
    private final String prefix;
    private final String message;

    public Printer(String prefix, String message) {
        this.prefix = prefix;
        this.message = message;
    }

    public Printer(String prefix, int message) {
        this(prefix, "" + message);
    }

    public Printer(String prefix, boolean message) {
        this(prefix, "" + message);
    }

    public Printer(String prefix, Object message) {
        this(prefix, message.toString());
    }

    public void print() {
        System.out.println(prefix + message);
    }
}
