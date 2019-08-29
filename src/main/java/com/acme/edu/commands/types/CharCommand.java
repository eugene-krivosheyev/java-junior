package com.acme.edu.commands.types;

import com.acme.edu.StateCommand;
import com.acme.edu.commands.Command;

public class CharCommand implements Command<Character> {
    private static final String CHAR_PREFIX = "char: ";
    private char message;

    public CharCommand (char message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return CHAR_PREFIX + message;
    }

    @Override
    public Command<Character> accumulate(Command command) throws IllegalArgumentException{
        return new CharCommand(message);
    }

    @Override
    public Character getMessage() { return message; }

    @Override
    public StateCommand getState() { return StateCommand.NONE; }
}
