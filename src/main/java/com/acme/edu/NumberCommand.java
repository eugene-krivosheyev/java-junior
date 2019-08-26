package com.acme.edu;

/**
 * Created by kate-c on 26/08/2019.
 */
public abstract class NumberCommand implements Command {
    @Override
    public String decorate() {
        return "primitive: " + getMessage();
    }

    @Override
    public MayBeFlushableCommand accumulate(Command command) {
        byte newMessage = ((ByteCommand) command).getMessage();
        long currentMessageToLong = (long)getMessage();
        if (currentMessageToLong + newMessage >= getMaxValue()) {
            return new MayBeFlushableCommand(new ByteCommand(newMessage), true);
        }
        setMessage(newMessage);

        return new MayBeFlushableCommand(new ByteCommand((byte)getMessage()), false);
    }

    public abstract long getMaxValue();
}
