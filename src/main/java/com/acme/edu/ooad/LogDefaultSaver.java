package com.acme.edu.ooad;

/**
 * Template Method [GoF]
 */
public abstract class LogDefaultSaver implements LogSaver {
    @Override
    public void save(Command message) {
       //....
        //....
        this.doStep(message);
        ///.....
        //.....
    }

    protected abstract void doStep(Command message);
}
