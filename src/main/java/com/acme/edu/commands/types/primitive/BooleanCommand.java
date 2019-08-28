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
    public Command<Boolean> accumulate(Command command) {
        try {
            if (!(command instanceof BooleanCommand))
                throw new IllegalArgumentException("Not boolean command!");
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return new BooleanCommand(message);
    }

    @Override
    public Boolean getMessage() { return message; }


    @Override
    public StateCommand getState() { return StateCommand.NONE; }
}
