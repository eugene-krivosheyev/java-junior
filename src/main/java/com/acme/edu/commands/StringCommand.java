package com.acme.edu.commands;

import java.util.Objects;

public class StringCommand implements Command {
    public static final String STRING_PREFIX = "string: ";

    private int counter = 1;
    private String buffer = "";
    private String message;

    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        updateBuffer(null);
        return buffer.replaceFirst("\n", "");
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof StringCommand;
    }

    @Override
    public StringCommand accumulate(Command other) {
        StringCommand otherStringCommand = (StringCommand) other;

        if (Objects.equals(message, otherStringCommand.message)) {
            ++counter;
        } else {
            updateBuffer(otherStringCommand.message);
        }
        return this;
    }

    private void updateBuffer(String newMessage) {
        buffer += decorate(message, counter);
        message = newMessage;
        counter = 1;
    }

    private static String decorate(String message, int counter) {
        String result = "\n" + STRING_PREFIX + message;
        if (counter > 1) {
            result += " (x" + counter + ")";
        }
        return result;
    }
}
