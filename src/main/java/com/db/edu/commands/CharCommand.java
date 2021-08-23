package com.db.edu.commands;

import static com.db.edu.Prefixes.CHAR_PREFIX;

public class CharCommand extends Command {

    private char message;

    public CharCommand(char message) {
        this.message = message;
    }

    public Command accumulate(Command another) {
        finishCommand();
        return another;
    }

    public void finishCommand() {
        builder.append(CHAR_PREFIX)
                .append(message)
                .append(System.lineSeparator());
    }
}
