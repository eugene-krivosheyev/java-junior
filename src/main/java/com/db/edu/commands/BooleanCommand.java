package com.db.edu.commands;

import static com.db.edu.Prefixes.PRIMITIVE_PREFIX;

public class BooleanCommand extends Command {

    private boolean message;

    public BooleanCommand(boolean message) {
        this.message = message;
    }

    public Command accumulate(Command another) {
        finishCommand();
        return another;
    }

    public void finishCommand() {
        builder.append(PRIMITIVE_PREFIX)
                .append(message)
                .append(System.lineSeparator());
    }
}
