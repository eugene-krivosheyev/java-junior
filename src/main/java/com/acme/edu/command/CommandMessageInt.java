package com.acme.edu.command;

import com.acme.edu.saver.Saver;

import static java.lang.System.lineSeparator;

public class CommandMessageInt implements CommandMessage {
    private int message;
    private int accumulator;

    public int getMessage() {
        return message;
    }

    public void setAccumulator(int previousAccumulator) {
        if (previousAccumulator == Integer.MAX_VALUE || previousAccumulator == Integer.MIN_VALUE) {
            this.accumulator = previousAccumulator;
        } else {
            this.accumulator = previousAccumulator + message;
        }
    }

    public CommandMessageInt(int message) {
        this.message = message;
        this.accumulator = message;
    }

    private void update(CommandMessageInt nextCommand, Saver saver) {
        int nextMessage = nextCommand.getMessage();
        if (nextMessage > 0) {
            if (accumulator > Integer.MAX_VALUE - nextMessage) {
                flush(saver);
                nextCommand.setAccumulator(Integer.MAX_VALUE);
            } else {
                nextCommand.setAccumulator(accumulator);
            }
        } else {
            if (accumulator < Integer.MIN_VALUE - nextMessage) {
                flush(saver);
                nextCommand.setAccumulator(Integer.MIN_VALUE);
            } else {
                nextCommand.setAccumulator(accumulator);
            }
        }
    }

    @Override
    public void update(CommandMessage nextCommand, Saver saver) {
        if (nextCommand instanceof CommandMessageInt) {
            update((CommandMessageInt) nextCommand, saver);
            return;
        }
        flush(saver);
    }

    @Override
    public String primitiveDecorator() {
        return "primitive: ";
    }

    @Override
    public void flush(Saver saver) {
        saver.save(accumulator + lineSeparator());
        accumulator = 0;
    }
}
