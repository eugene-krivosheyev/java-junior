package com.acme.edu.ooaddemo2;

import java.util.Objects;

public class StringCommand implements Command {
    private String message;
    private int severity;

    public StringCommand(String message, int severity) {
        this.message = message;
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int getSeverity() {
        return severity;
    }

    @Override
    public String getDecorated() {
        return "string: " + message;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        final boolean isStringCommand = other instanceof StringCommand;
        if (!isStringCommand) return false;

        final StringCommand otherStringCommand = (StringCommand) other;
        return areMessagesEqual(otherStringCommand);
    }

    @Override
    public Command accumulate(Command other) {
        return null;
    }

    @Override
    public Object getDta() {
        return message;
    }


    private boolean areMessagesEqual(StringCommand other) {
        return Objects.equals(this.message, other.getMessage());
    }
}
