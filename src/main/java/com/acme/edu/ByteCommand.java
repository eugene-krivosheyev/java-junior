package com.acme.edu;

/**
 * Created by kate-c on 25/08/2019.
 */
public class ByteCommand implements Command {

    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    public Byte getMessage() {
        return message;
    }

    @Override
    public void setMessage(Object message) {
        this.message = (byte)message;
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
    public MayBeFlushableCommand accumulate(Command command) {
        byte newMessage = ((ByteCommand) command).getMessage();
        long currentMessageToLong = message;
        if (currentMessageToLong + newMessage >= Byte.MAX_VALUE) {
            return new MayBeFlushableCommand(new ByteCommand(newMessage), true);
        }
        message += newMessage;

        return new MayBeFlushableCommand(new ByteCommand(this.message), false);
    }
}
