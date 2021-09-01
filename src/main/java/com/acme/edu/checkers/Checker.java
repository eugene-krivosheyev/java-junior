package com.acme.edu.checkers;

import com.acme.edu.savers.Saver;

public abstract class Checker<T> {
    protected Saver saver;

    public abstract T check(Object message);
}
