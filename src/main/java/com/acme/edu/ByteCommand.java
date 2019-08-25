package com.acme.edu;

/**
 * Created by kate-c on 25/08/2019.
 */
public class ByteCommand implements Command{

    byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    public Byte getMessage() {
        return message;
    }

    @Override
    public String decorate() {
        return "primitive: " + message;
    }

    @Override
    public boolean isTypeEqual(Command other) {
        return other instanceof ByteCommand;
    }


    @Override
    public CommandWrapper accumulate(Command command) {
        byte newMessage = ((ByteCommand) command).getMessage();
        long currentMessageToLong = message;
        if (currentMessageToLong + newMessage >= Byte.MAX_VALUE) {
            return new CommandWrapper(new ByteCommand(newMessage), true);
        }
        message += newMessage;

        return new CommandWrapper(new ByteCommand(this.message), false);
    }
}
