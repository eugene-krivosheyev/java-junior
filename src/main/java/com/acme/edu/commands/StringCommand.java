package com.acme.edu.commands;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.util.Objects;

/**
 * Created by kate-c on 23/08/2019.
 */
public class StringCommand implements Command {
    private String message;
    private int count;

    public StringCommand(String message) {
        this.message = message;
        this.count = 1;
    }

    StringCommand(String message, int count) {
        this.message = message;
        this.count = count;
    }

    @Override
    public String decorate() {
        String result = "string: " + this.message;
        if (count > 1) {
            result += " (x" + count + ")";
        }
        return result;
    }

    @Override
    public Command accumulate(Command other) {
        if (!(other instanceof StringCommand)) throw new ValueException("Invalid command type");
        StringCommand addend = (StringCommand) other;
        if (!Objects.equals(this.message, addend.message)) {
            throw new ValueException("Strings are not equal");
        }
        return new StringCommand(this.message, this.count + addend.count);
    }

    @Override
    public boolean canAccumulateWith(Command other) {
        if (!(other instanceof StringCommand)) return false;
        StringCommand addend = (StringCommand) other;
        return Objects.equals(this.message, addend.message);
    }
}
