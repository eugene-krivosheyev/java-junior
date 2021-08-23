package com.db.edu.commands;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.db.edu.Prefixes.STRING_PREFIX;

public class StringCommand extends Command {

    private String message;
    private int repeats = 1;

    public StringCommand(String message) {
        this.message = message;
    }

    public StringCommand(String[] message) {
        this.message = Arrays.stream(message).collect(Collectors.joining(System.lineSeparator()));
    }

    private String getMessage() {
        return message;
    }

    public Command accumulate(Command another) {
        if (another instanceof StringCommand && ((StringCommand) another).getMessage().equals(getMessage())) {
            repeats++;
            return this;
        } else {
            finishCommand();
            return another;
        }
    }

    public void finishCommand() {
        builder.append(STRING_PREFIX).append(getMessage());
        if (repeats > 1) {
            builder.append(String.format(" (x%d)", repeats));
        }
        builder.append(System.lineSeparator());
    }

}
