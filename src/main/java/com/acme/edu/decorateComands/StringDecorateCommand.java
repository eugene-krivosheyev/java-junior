package com.acme.edu.decorateComands;

import static com.acme.edu.LoggerType.STRING;

public class StringDecorateCommand implements DecorateCommand {
    private String message;

    public StringDecorateCommand(String message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return STRING.getType() + message;
    }
}
