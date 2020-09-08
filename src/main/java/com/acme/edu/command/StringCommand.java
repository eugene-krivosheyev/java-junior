package com.acme.edu.command;

import com.acme.edu.command.Command;

public class StringCommand implements Command {

    public static String STRING_PREFIX = "string: ";

    public String message;

    public static int sameCommandCounter = 0;

    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return STRING_PREFIX + message;
    }

    @Override
    public String decorate() {
        if (sameCommandCounter > 0)
            return STRING_PREFIX + message + " (x" + ++sameCommandCounter + ")";
        else
            return STRING_PREFIX + message;
    }

    @Override
    public boolean isSameType(Command cmd) {
        return cmd instanceof StringCommand;
    }

    @Override
    public Command reduce(Command cmd) {
        StringCommand tmp = (StringCommand) cmd;
        if (this.message.contains(tmp.message)) {
            sameCommandCounter++;
        }
        else {
            sameCommandCounter = 0;
        }
        this.message += System.lineSeparator() +  cmd.decorate();
        return this;
    }

}
