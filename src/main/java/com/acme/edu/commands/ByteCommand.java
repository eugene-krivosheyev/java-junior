package com.acme.edu.commands;

public class ByteCommand extends PrimitiveCommand {
    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public String getStringMessage() {
        return String.valueOf(message);
    }

    public byte getMessage() {
        return message;
    }

    @Override
    public boolean isTypeEqual(Command command) {
        return command instanceof ByteCommand;
    }

    @Override
    public void accumulate(Command command) {
        byte newMessage = ((ByteCommand) command).getMessage();
        message += newMessage;
    }

    @Override
    public boolean isSaveRequired(Command command) {
        byte newMessage = ((ByteCommand) command).getMessage();
        return message > (Byte.MAX_VALUE - newMessage) || message < (Byte.MIN_VALUE + newMessage);
    }
}
