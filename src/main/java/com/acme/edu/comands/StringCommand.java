package com.acme.edu.comands;

import static com.acme.edu.LoggerType.STRING;

public class StringCommand implements Command {
    private String message;

    public StringCommand(String message) {
        this.message = message;
    }


    @Override
    public String decorate() {
        return STRING.getType() + message;
    }
}
