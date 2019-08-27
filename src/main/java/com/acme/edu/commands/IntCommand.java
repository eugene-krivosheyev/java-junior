package com.acme.edu.commands;

public class IntCommand extends PrimitiveCommand {
    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    public String getStringMessage() {
        return String.valueOf(message);
    }

    // TODO: 2019-08-27 int -> Integer
    public int getMessage() {
        return message;
    }

    @Override
    public boolean isTypeEqual(Command command) {
        return command instanceof IntCommand;
    }

    @Override
    public IntCommand accumulate(Command command) {
        int newMessage = ((IntCommand) command).getMessage();
        return new IntCommand(message + newMessage);
    }

    @Override
    public boolean isSaveRequired(Command command) {
        int newMessage = ((IntCommand) command).getMessage();
        return message > (Integer.MAX_VALUE - newMessage) || message < (Integer.MIN_VALUE + newMessage);
    }
}
