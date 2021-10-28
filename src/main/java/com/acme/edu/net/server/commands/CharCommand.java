package com.acme.edu.net.server.commands;

import com.acme.edu.LoggerController;
import com.acme.edu.messages.CharMessage;
import com.acme.edu.messages.IntMessage;

public class CharCommand implements LogCommand {
    private char value;

    public CharCommand(char value) {
        this.value = value;
    }
    @Override
    public void execute(LoggerController loggerController) {
        loggerController.log(new CharMessage(value));
    }
}
