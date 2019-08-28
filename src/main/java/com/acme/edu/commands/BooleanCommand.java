package com.acme.edu.commands;

import com.acme.edu.savers.Saver;

/**
 * Created by kate-c on 25/08/2019.
 */
public class BooleanCommand extends Command {
    boolean message;

    public BooleanCommand(boolean message) {
        this.message = message;
    }

    public Boolean getMessage() {
        return message;
    }

    @Override
    public String decorate() {
        return "primitive: " + message;
    }

    @Override
    public boolean isTypeEqual(Command other) {
        return other instanceof BooleanCommand;
    }

    @Override
    public Command accumulate(Command command, Saver saver) {
        throw new UnsupportedOperationException("Booleans can't be accumulated!");
    }

}
