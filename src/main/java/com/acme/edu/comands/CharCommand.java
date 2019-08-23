package com.acme.edu.comands;

import static com.acme.edu.LoggerType.CHAR;

public class CharCommand implements Command {
    private String message;

    public CharCommand(String message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return CHAR.getType() + message;
    }
}
