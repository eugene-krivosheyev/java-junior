package com.acme.edu.commands.types.primitive;

import com.acme.edu.StateCommand;
import com.acme.edu.overflow.ControllerOverflow;
import com.acme.edu.commands.Command;

public class IntCommand extends PrimitiveCommand implements Command<Integer> {
    private Integer message;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public String decorate() { return super.getPrimitivePrefix() + message; }

    @Override
    public Command<Integer> accumulate(Command command) {
        if (command instanceof IntCommand) {
            ControllerOverflow.controlOverflow((Integer) command.getMessage(), this);
            return new IntCommand(message);
        }
        else {
            throw new IllegalArgumentException("Wrong command!");
        }
    }

    @Override
    public Integer getMessage() { return message; }


    public void setMessage(int message) { this.message = message; }

    @Override
    public StateCommand getState() { return StateCommand.INT; }

}
