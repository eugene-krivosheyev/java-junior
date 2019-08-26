package com.acme.edu;

/**
 * Created by kate-c on 23/08/2019.
 */
public class IntCommand implements Command {

    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    public Integer getMessage() {
        return message;
    }

    @Override
    public void setMessage(Object message) {
        this.message = (int)message;
    }

    @Override
    public String decorate() {
        return "primitive: " + message;
    }

    @Override
    public boolean isTypeEqual(Command other) {
        return other instanceof IntCommand;
    }


    @Override
    public MayBeFlushableCommand accumulate(Command command) {
        int newMessage = ((IntCommand) command).getMessage();
        long currentMessageToLong = message;
        if (currentMessageToLong + newMessage >= Integer.MAX_VALUE) {
            return new MayBeFlushableCommand(new IntCommand(newMessage), true);
        }
        message += newMessage;
        return new MayBeFlushableCommand(new IntCommand(this.message), false);
    }
}
