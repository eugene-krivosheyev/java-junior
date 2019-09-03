package com.acme.edu.commands.types;

import com.acme.edu.StateCommand;
import com.acme.edu.commands.Command;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.FileSaver;
import com.acme.edu.saver.SaverException;

public class StringCommand implements Command<String> {
    private String message;
    private int counterOfStrings;

    public StringCommand(String message) {
        this.message = message;
        this.counterOfStrings = 1;
    }

    public StringCommand(String message, int counterOfStrings) {
        this.message = message;
        this.counterOfStrings = counterOfStrings;
    }

    @Override
    public String decorate() {
        return "string: " + message;
    }

    @Override
    public Command<String> accumulate(Command command) throws SaverException {
        if (command.getMessage().equals(message)) counterOfStrings++;
        else {
            if (message != null) {
                new FileSaver().saveWithoutPrefix(new StringCommand(getMessage()));
            }
            counterOfStrings = 1;
            message = (String) command.getMessage();
        }
        return new StringCommand(message, counterOfStrings);
    }

    @Override
    public String getMessage() {
        if (counterOfStrings > 1) { message = message + " (x" + counterOfStrings + ")"; }
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public StateCommand getState() { return StateCommand.STR; }



}

