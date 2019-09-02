package com.acme.edu.mylogger.commands;

public class StringCommand implements Command {
    private final static String STRING_PREFIX = "string: ";
    private String message;
    private int repeats;

    public StringCommand(String message) {
        this.message = message;
        this.repeats = 1;
    }

    public StringCommand(String message, int repeats) {
        this.message = message;
        this.repeats = repeats;
    }

    @Override
    public Command accumulate(Command other) {
        return new StringCommand(this.message, this.repeats + 1);
    }

    @Override
    public String getDecorated() {
        return this.repeats > 1
                ? STRING_PREFIX + this.message + " (x" + repeats + ")"
                : STRING_PREFIX + this.message;
    }

    @Override
    public Object getMessage() {
        return message;
    }

    public int getRepeats() {
        return repeats;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        if (other == null) {
            return false;
        }
        return this.message == other.getMessage();
    }

    @Override
    public boolean isOverflow() {
        return false;
    }
}
