package com.acme.edu.commands;

import com.acme.edu.StateCommand;
import com.acme.edu.overflow.OverflowException;

public interface Command<T>  {
    String decorate();
    Command<T> accumulate(Command command) throws OverflowException, IllegalArgumentException;
    T getMessage();
    StateCommand getState();
}
