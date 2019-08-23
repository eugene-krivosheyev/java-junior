package com.acme.edu;

/**
 * Created by kate-c on 23/08/2019.
 */
public abstract class Command {
    //abstract String decorate();
    abstract void accumulate();
    protected Accumulator accumulator = null;
}
