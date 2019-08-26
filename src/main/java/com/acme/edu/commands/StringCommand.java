package com.acme.edu.commands;

import com.acme.edu.Logger.LoggingType;

import java.util.Objects;

public class StringCommand implements Command {
    private static String PREFIX_STRING = "string: ";

    private String message;
    private LoggingType type;
    private int count = 1;

    public StringCommand(String message) {
        this.message = message;
        this.type = LoggingType.STRING;
    }


    @Override
    public LoggingType getType() {
        return type;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return this.type == other.getType() && Objects.equals(this.getMessage(),other.getMessage());
    }

    public String getDecoratedMessage() {
        if (count < 2) {
            return PREFIX_STRING + message;
        } else {
            return PREFIX_STRING + message + " (x" + count + ")";
        }
    }

    @Override
    public CommandAccumulateInfo accumulate(Command other) {
        if (other == null) return new CommandAccumulateInfo(this, null, -1);
        if (! (other instanceof StringCommand)) return new CommandAccumulateInfo(this, other.getDecoratedMessage(), -1);

        if (!isTypeEquals(other)) return new CommandAccumulateInfo(this, other.getDecoratedMessage(), 0);
        this.count += ((StringCommand) other).count;
        String returnMessage = (String) this.getMessage();

        return new CommandAccumulateInfo(this, null, 0);
    }

    @Override
    public Object getMessage() {
        return message;
    }
}
