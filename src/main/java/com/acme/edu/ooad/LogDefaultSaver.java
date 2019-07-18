package com.acme.edu.ooad;

/**
 * Template Method [GoF]
 */
public abstract class LogDefaultSaver implements LogSaver {
    @Override
    public String save(Command message) {
       //....
        //....
        this.doStep(message);
        ///.....
        //.....
        return null;
    }

    protected abstract void doStep(Command message);
}
