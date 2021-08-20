package com.db.edu.commands;

import static com.db.edu.Prefixes.REFERENCE_PREFIX;

public class ObjectCommand extends Command {

    private Object message;

    public ObjectCommand(Object message) {
        this.message = message;
    }

    public Command accumulate(Command another) {
        finishCommand();
        return another;
    }

    @Override
    public void finishCommand() {
        builder.append(REFERENCE_PREFIX)
                .append(message)
                .append(System.lineSeparator());
    }
}
