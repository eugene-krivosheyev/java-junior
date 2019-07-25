package com.acme.edu.command;

import com.acme.edu.exceptions.MaxValueReachedException;
import com.acme.edu.saver.Saver;

import java.io.IOException;

import static java.lang.System.lineSeparator;

public class CommandMessageString implements CommandMessage {
    private String message;
    private int sameStringCount = 1;

    public void setSameStringCount(int sameStringCount) throws MaxValueReachedException {
        this.sameStringCount = sameStringCount;
        if (sameStringCount < 0) {
            throw new MaxValueReachedException("Number of same strings overflowed value");
        }
    }

    public CommandMessageString(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private void update(CommandMessageString nextCommand, Saver saver) throws MaxValueReachedException, IOException {
        if (message.equals(nextCommand.getMessage())) {
            nextCommand.setSameStringCount(sameStringCount + 1);
            return;
        }
        flush(saver);
    }

    @Override
    public void update(CommandMessage nextCommand, Saver saver) throws MaxValueReachedException, IOException {
        if (nextCommand instanceof CommandMessageString) {
            update((CommandMessageString) nextCommand, saver);
            return;
        }
        flush(saver);
    }

    @Override
    public String primitiveDecorator() {
        return "string: ";
    }

    @Override
    public void flush(Saver saver) throws IOException {
        saver.save(message + (sameStringCount == 1 ? "" : " (x" + sameStringCount + ")") + lineSeparator());
        sameStringCount = 1;
    }
}
