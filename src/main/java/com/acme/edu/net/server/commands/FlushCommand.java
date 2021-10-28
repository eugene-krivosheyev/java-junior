package com.acme.edu.net.server.commands;

import com.acme.edu.LoggerController;

public class FlushCommand implements LogCommand {
    @Override
    public void execute(LoggerController loggerController) {
        loggerController.flush();
    }
}
