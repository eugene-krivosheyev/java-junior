package com.acme.edu;

class DefaultMessageProcessor implements MessageProcessor {

    private final String format;

    DefaultMessageProcessor(String format) {
        this.format = format;
    }

    @Override
    public void process(Object message) {
        System.out.print(String.format(format, message));
    }
}