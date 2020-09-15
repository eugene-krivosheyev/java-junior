package com.acme.edu.command;

import com.acme.edu.command.Command;

public class StringCommand implements Command {

    public static String STRING_PREFIX = "string: ";

    public String message;

    public static int sameCommandCounter = 1;

    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return STRING_PREFIX + message + this.decorate();
    }

    @Override
    public String decorate() {
        if (sameCommandCounter > 1)
            return  " (x" + sameCommandCounter + ")" ;
        return "";
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
        } else {
            this.message += this.decorate() + System.lineSeparator() + tmp.message;
            sameCommandCounter = 1;
        }
        return this;
    }

    @Override
    public boolean isOverflow(Command cmd) {
        return false;
    }

}
