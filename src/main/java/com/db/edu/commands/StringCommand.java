package com.db.edu.commands;

import static com.db.edu.Prefixes.STRING_PREFIX;

public class StringCommand extends Command {

    private String message;
    private int repeats = 1;

    public StringCommand(String message) {
        this.message = message;
    }

    private String getMessage() {
        return message;
    }

    public Command accumulate(Command another) {
        if (another instanceof StringCommand) {
            String anotherMessage = ((StringCommand) another).getMessage();
            if (message.equals(anotherMessage)) {
                repeats++;
                return this;
            }
            finishCommand();
            return another;
        } else {
            finishCommand();
            return another;
        }
    }

    public void finishCommand() {
        builder.append(STRING_PREFIX).append(message);
        if (repeats > 1) {
            builder.append(String.format(" (x%d)", repeats));
        }
        builder.append(System.lineSeparator());
    }

}
