package com.acme.edu.commands.types.primitive;

import com.acme.edu.StateCommand;
import com.acme.edu.overflow.ControllerOverflow;
import com.acme.edu.commands.Command;
import com.acme.edu.overflow.OverflowException;

public class ByteCommand extends PrimitiveCommand implements Command<Byte> {
    private Byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return super.getPrimitivePrefix() + message;
    }

    @Override
    public Command<Byte> accumulate(Command command) {
        try {
            if (command instanceof ByteCommand)
                ControllerOverflow.controlOverflow((Byte) command.getMessage(), this);
            else
                throw new IllegalArgumentException("Not a byte command!");
        } catch (IllegalArgumentException | OverflowException e) {
            e.printStackTrace();
        }
        return new ByteCommand(message);
    }

    @Override
    public Byte getMessage() { return message; }

    public void setMessage(byte message) { this.message = message; }

    @Override
    public StateCommand getState() { return StateCommand.BYTE; }
}
