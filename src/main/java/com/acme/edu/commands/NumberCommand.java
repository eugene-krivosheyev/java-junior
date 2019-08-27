package com.acme.edu.commands;

import com.acme.edu.CommandAndFlushOptional;

/**
 * Created by kate-c on 26/08/2019.
 */
public abstract class NumberCommand implements Command {
    @Override
    public String decorate() {
        return "primitive: " + getMessage();
    }

    @Override
    public CommandAndFlushOptional accumulate(Command command) {
        byte newMessage = ((ByteCommand) command).getMessage();
        long currentMessageToLong = (long)getMessage();
        if (currentMessageToLong + newMessage >= getMaxValue()) {
            return new CommandAndFlushOptional(new ByteCommand(newMessage), true);
        }
        setMessage(newMessage);

        return new CommandAndFlushOptional(new ByteCommand((byte)getMessage()), false);
    }

    public abstract long getMaxValue();
}
