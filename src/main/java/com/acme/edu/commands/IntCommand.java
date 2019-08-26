package com.acme.edu.commands;

public class IntCommand extends PrimitiveCommand {
    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    public String getStringMessage() {
        return String.valueOf(message);
    }

    public int getMessage() {
        return message;
    }

    @Override
    public boolean isTypeEqual(Command command) {
        return command instanceof IntCommand;
    }

    @Override
    public void accumulate(Command command) {
        int newMessage = ((IntCommand) command).getMessage();
        message += newMessage;
    }

    @Override
    public boolean isSaveRequired(Command command) {
        int newMessage = ((IntCommand) command).getMessage();
        return message > (Integer.MAX_VALUE - newMessage) || message < (Integer.MIN_VALUE + newMessage);
    }
}
