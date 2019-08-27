package com.acme.edu.commands;

import com.acme.edu.CommandAndFlushOptional;

/**
 * Created by kate-c on 25/08/2019.
 */
public class BooleanCommand implements Command {

    boolean message;

    public BooleanCommand(boolean message) {
        this.message = message;
    }

    public Boolean getMessage() {
        return message;
    }

    @Override
    public void setMessage(Object message) {
        this.message = (boolean)message;
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
    public CommandAndFlushOptional accumulate(Command command) {
        // TODO
        throw new UnsupportedOperationException("Booleans can't be accumulated!");
    }
}
