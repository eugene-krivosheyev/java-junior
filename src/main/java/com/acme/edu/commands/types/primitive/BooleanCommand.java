package com.acme.edu.commands.types.primitive;

import com.acme.edu.StateCommand;
import com.acme.edu.commands.Command;

public class BooleanCommand extends PrimitiveCommand implements Command<Boolean> {
    private boolean message;

    public BooleanCommand(boolean message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return super.getPrimitivePrefix() + message;
    }

    @Override
    public Command<Boolean> accumulate(Command command) { return null; }

    @Override
    public Boolean getMessage() { return message; }


    @Override
    public StateCommand getState() { return StateCommand.NONE; }
}
