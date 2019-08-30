package com.acme.edu.commands;

import com.acme.edu.savers.Saver;

/**
 * Created by kate-c on 25/08/2019.
 */
public class ByteCommand extends NumberCommand {
    private final static byte MAX_VALUE = Byte.MAX_VALUE;
    private final static byte MIN_VALUE = Byte.MIN_VALUE;

    public ByteCommand(byte message) {
        super(message);
    }

    public Byte getMessage() {
        return (byte) message;
    }

    @Override
    public boolean isTypeEqual(Command other) {
        return other instanceof ByteCommand;
    }

    @Override
    public Command accumulate(Command command, Saver saver) {
        if (command == null) {
            throw new IllegalArgumentException("Null argument");
        }
        if (!(command instanceof ByteCommand)) {
            throw new IllegalArgumentException("Not the same type of message");
        }
        byte newMessage = ((ByteCommand) command).getMessage();
        return accumulatorTemplate(this.message, newMessage,
                MIN_VALUE, MAX_VALUE,
                saver,
                new ByteCommand((byte) ((byte) message + newMessage)),
                new ByteCommand(newMessage));

    }
}
