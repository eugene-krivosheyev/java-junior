package com.acme.edu.commands;

public interface Command<T> {
    String decorate();
    T getMessage();
}
