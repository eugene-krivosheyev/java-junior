package com.acme.edu.commands.types.primitive;

import com.acme.edu.Logger;
import com.acme.edu.buffer.BufferState;
import com.acme.edu.buffer.ControllerOverflow;
import com.acme.edu.commands.Command;

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
        ControllerOverflow.controlOverflow((Byte) command.getMessage(), this);
        return this;
    }

    @Override
    public Byte getMessage() { return message; }

    public void setMessage(byte message) { this.message = message; }

    @Override
    public BufferState getState() { return BufferState.BYTE; }
}
