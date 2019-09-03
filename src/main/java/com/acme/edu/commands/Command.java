package com.acme.edu.commands;

import com.acme.edu.StateCommand;
import com.acme.edu.overflow.OverflowException;
import com.acme.edu.saver.SaverException;

public interface Command<T>  {
    String decorate();
    Command<T> accumulate(Command command) throws OverflowException, SaverException;
    T getMessage();
    StateCommand getState();
}
