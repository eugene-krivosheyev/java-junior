package com.acme.edu.net.server.commands;

import com.acme.edu.LoggerController;
import com.acme.edu.messages.ByteMessage;
import com.acme.edu.messages.IntMessage;

public class ByteCommand implements LogCommand {
    private byte value;

    public ByteCommand(byte value) {
        this.value = value;
    }

    @Override
    public void execute(LoggerController loggerController) {
        loggerController.log(new ByteMessage(value));
    }
}
