package com.acme.edu.command;

import com.acme.edu.message.Prefix;

public class StringCommand implements LoggerCommand {
    private String stringAccumulator = "";
    private int stringDuplicates = 0;

    public StringCommand(String message) {
        stringAccumulator = message;
    }

    public StringCommand(String stringAccumulator, int stringDuplicates) {
        this.stringAccumulator = stringAccumulator;
        this.stringDuplicates = stringDuplicates;
    }

    @Override
    public String toString() {
        String buffer = Prefix.STRING.getValue() + stringAccumulator;
        if (stringDuplicates != 0) {
            return buffer + " (x" + ++stringDuplicates + ")";
        } else {
            return buffer;
        }
    }

    @Override
    public LoggerCommand accumulate(LoggerCommand newLoggerCommand) {
        return new StringCommand(stringAccumulator, ++stringDuplicates);
    }

    @Override
    public boolean isSameType(LoggerCommand loggerCommand) {
        if (loggerCommand instanceof StringCommand) {
            return ((StringCommand) loggerCommand).stringAccumulator.equals(stringAccumulator);
        }

        return false;
    }
}
