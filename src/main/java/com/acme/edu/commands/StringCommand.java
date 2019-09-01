package com.acme.edu.commands;

import com.acme.edu.savers.Saver;

import java.util.Objects;

// TODO: Rework whole class!
public class StringCommand implements Command, AccumulableCommand {
    public static final String STRING_PREFIX = "string: ";

    private int counter = 1;
    private String buffer = "";
    private String message;

    public StringCommand(String message) {
        this.message = message;
    }

    private StringCommand(String buffer, String message) {
        this.buffer = buffer;
        this.message = message;
    }

    private StringCommand(int counter, String buffer, String message) {
        this.counter = counter;
        this.buffer = buffer;
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return buffer.replaceFirst("\n", "") + decorate(message, counter);
    }

    @Override
    public StringCommand accumulate(Command other, Saver saver) {
        String otherMessage = ((StringCommand) other).getMessage();
        if (Objects.equals(message, otherMessage)) {
            return getIncrementedCopy();
        } else {
            return getCopyWithResolvedBuffer(otherMessage);
        }
    }

    private String getMessage() {
        return message;
    }

    private StringCommand getIncrementedCopy() {
        return new StringCommand(this.counter + 1, this.buffer, this.message);
    }

    private StringCommand getCopyWithResolvedBuffer(String newMessage) {
        return new StringCommand(this.buffer + decorate(this.message, this.counter), newMessage);
    }

    private static String decorate(String message, int counter) {
        String result = "\n" + STRING_PREFIX + message;
        if (counter > 1) {
            result += " (x" + counter + ")";
        }
        return result;
    }
}
