package com.acme.edu.command;

import com.acme.edu.saver.Saver;

import static java.lang.System.lineSeparator;

public class CommandMessageString implements CommandMessage {
    private String message;
    private int sameStringCount = 1;

    public void setSameStringCount(int sameStringCount) {
        this.sameStringCount = sameStringCount;
    }

    public CommandMessageString(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private void update(CommandMessageString nextCommand, Saver saver) {
        if (message.equals(nextCommand.getMessage())) {
            nextCommand.setSameStringCount(sameStringCount + 1);
            return;
        }
        flush(saver);
    }

    @Override
    public void update(CommandMessage nextCommand, Saver saver) {
        if (nextCommand instanceof CommandMessageString){
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
    public void flush(Saver saver) {
        saver.save(message + (sameStringCount == 1 ? "" : " (x" + sameStringCount + ")") + lineSeparator());
        sameStringCount = 1;
    }
}
