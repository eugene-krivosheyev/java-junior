package com.acme.edu.net.server.commands;

import com.acme.edu.LoggerController;
import com.acme.edu.messages.IntMessage;

public class IntCommand implements LogCommand {
    private int value;

    public IntCommand(int value) {
        this.value = value;
    }
    @Override
    public void execute(LoggerController loggerController) {
        loggerController.log(new IntMessage(value));
    }
}
