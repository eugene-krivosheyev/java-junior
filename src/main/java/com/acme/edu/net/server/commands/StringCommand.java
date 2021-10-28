package com.acme.edu.net.server.commands;

import com.acme.edu.LoggerController;
import com.acme.edu.messages.IntMessage;
import com.acme.edu.messages.StringMessage;

public class StringCommand implements LogCommand {
    private String value;

    public StringCommand(String value) {
        this.value = value;
    }
    @Override
    public void execute(LoggerController loggerController) {
        loggerController.log(new StringMessage(value));
    }
}
