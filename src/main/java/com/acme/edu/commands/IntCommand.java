package com.acme.edu.commands;

import com.acme.edu.savers.Saver;

/**
 * Created by kate-c on 23/08/2019.
 */
public class IntCommand extends NumberCommand {
    //private int message;
    private final static int MAX_VALUE = Integer.MAX_VALUE;
    private final static int MIN_VALUE = Integer.MIN_VALUE;

    public IntCommand(int message) {
        super(message);
    }

    public Integer getMessage() {
        return (int)message;
    }

    @Override
    public boolean isTypeEqual(Command other) {
        return other instanceof IntCommand;
    }

    @Override
    public Command accumulate(Command command, Saver saver) {
        if (command == null) {
            throw new IllegalArgumentException("Null argument");
        }
        if (!(command instanceof IntCommand)) {
            throw new IllegalArgumentException("Not the same type of message");
        }
        int newMessage = ((IntCommand) command).getMessage();
        return accumulatorTemplate(this.message, newMessage,
                                   MIN_VALUE, MAX_VALUE,
                                   saver,
                                   new IntCommand((int)message + newMessage),
                                   new IntCommand(newMessage));

    }
}
