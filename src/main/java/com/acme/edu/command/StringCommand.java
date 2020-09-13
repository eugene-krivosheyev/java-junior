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
        return STRING_PREFIX + message;
    }

    @Override
    public String decorate() {
        if (sameCommandCounter > 1)
            return this.message + " (x" + sameCommandCounter + ")";
        return message;
    }

    @Override
    public boolean isSameType(Command cmd) {
        return cmd instanceof StringCommand;
    }

    @Override
    public Command reduce(Command cmd) {
        StringCommand tmp = (StringCommand) cmd;
        //System.err.println(tmp.message);
        if (this.message.contains(tmp.message)) {
            sameCommandCounter++;
        }
        else {
            this.message +=  System.lineSeparator() + tmp.decorate() ;// + tmp.message;
            //System.err.println("mes: " + this.message);
            sameCommandCounter = 1;
        }
        return this;
    }

    @Override
    public boolean isOverflow(Command cmd) {
        return false;
    }

}
