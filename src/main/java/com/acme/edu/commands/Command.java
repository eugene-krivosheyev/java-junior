package com.acme.edu.commands;

import com.acme.edu.StateCommand;

public interface Command<T>  {
    String decorate();
    Command<T> accumulate(Command command);
    T getMessage();
    StateCommand getState();
}
