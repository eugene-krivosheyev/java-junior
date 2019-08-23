package com.acme.edu.comands;

import static com.acme.edu.LoggerType.REFERENCE;

public class ReferenceCommand implements Command {
    private String message;

    public ReferenceCommand(String message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return REFERENCE.getType() + message;
    }
}
