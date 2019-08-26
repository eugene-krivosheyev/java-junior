package com.acme.edu.commands;

/**
 * Created by kate-c on 23/08/2019.
 */
public interface Command {
    String decorate();
    default Command accumulate(Command other) {
        return null;
    }
    default boolean canAccumulateWith(Command other) {
        return false;
    }
}
