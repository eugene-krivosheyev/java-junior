package com.acme.edu.commands;

import com.acme.edu.buffer.BufferState;

public interface Command<T> {
    String decorate();
    Command<T> accumulate(Command command);
    T getMessage();
    BufferState getState();
}
