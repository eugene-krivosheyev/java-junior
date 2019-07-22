package com.acme.edu.command;

import com.acme.edu.saver.Saver;

import static java.lang.System.lineSeparator;

public class CommandMessageByte implements CommandMessage {
    private int message;
    private int accumulator;

    public int getMessage() {
        return message;
    }

    public void setAccumulator(int previousAccumulator) {
        if (previousAccumulator == Byte.MAX_VALUE || previousAccumulator == Byte.MIN_VALUE) {
            this.accumulator = previousAccumulator;
        } else {
            this.accumulator = previousAccumulator + message;
        }
    }

    public CommandMessageByte(byte message) {
        this.message = message;
        this.accumulator = message;
    }

    private void update(CommandMessageByte nextCommand, Saver saver) {
        int nextMessage = nextCommand.getMessage();
        if (nextMessage > 0) {
            if (accumulator > Byte.MAX_VALUE - nextMessage) {
                flush(saver);
                nextCommand.setAccumulator(Byte.MAX_VALUE);
            } else {
                nextCommand.setAccumulator(accumulator);
            }
        } else {
            if (accumulator < Byte.MIN_VALUE - nextMessage) {
                flush(saver);
                nextCommand.setAccumulator(Byte.MIN_VALUE);
            } else {
                nextCommand.setAccumulator(accumulator + nextMessage);
            }
        }
    }

    @Override
    public void flush(Saver saver) {
        saver.save(accumulator + lineSeparator());
        accumulator = 0;
    }

    @Override
    public void update(CommandMessage nextCommand, Saver saver) {
        if (nextCommand instanceof CommandMessageByte) {
            update((CommandMessageByte) nextCommand, saver);
            return;
        }
        flush(saver);
    }

    @Override
    public String primitiveDecorator() {
        return "primitive: ";
    }
}
