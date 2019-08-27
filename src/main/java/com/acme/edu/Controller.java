package com.acme.edu;

import com.acme.edu.commands.Command;
import com.acme.edu.commands.CommandAccumulateInfo;
import com.acme.edu.commands.IntArrayCommand;
import com.acme.edu.saver.Saver;

public class Controller {
    private final static String PREFIX_PRIMITIVE = "primitive: ";
    private final static String PREFIX_PRIMITIVES_ARRAY = "primitives array: ";
    private final static String PREFIX_CHAR = "char: ";
    private final static String PREFIX_STRING = "string: ";
    private final static String PREFIX_REFERENCE = "reference: ";

    private int count = 0;
    private String loggedString = "";

    Command lastCommand = null;

    private Saver saver;

    public Controller(Saver saver) {
        this.saver = saver;
    }

    public void log(Command command) {
        if (lastCommand == null) {
            lastCommand = command;
            return;
        }

        CommandAccumulateInfo info = command.accumulate(lastCommand);
        lastCommand = info.getCommand();

        String message = info.getMessage();
        if (message != null) {
            saver.save(message);
        }
        lastCommand = command;
    }

    public void flush() {
        if (lastCommand != null) {
            String message = lastCommand.getDecoratedMessage();
            saver.save(message);
        }
        lastCommand = null;
    }
}
