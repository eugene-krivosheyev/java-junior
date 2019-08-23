package com.acme.edu.decorateComands;

import static com.acme.edu.LoggerType.CHAR;

public class CharDecorateCommand implements DecorateCommand {
    private String message;

    public CharDecorateCommand(String message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return CHAR.getType() + message;
    }
}
