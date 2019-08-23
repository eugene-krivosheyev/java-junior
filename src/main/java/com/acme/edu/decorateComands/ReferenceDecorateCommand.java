package com.acme.edu.decorateComands;

import static com.acme.edu.LoggerType.REFERENCE;

public class ReferenceDecorateCommand implements DecorateCommand {
    private String message;

    public ReferenceDecorateCommand(String message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return REFERENCE.getType() + message;
    }
}
