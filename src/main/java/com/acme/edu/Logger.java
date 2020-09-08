package com.acme.edu;

import com.acme.edu.command.IntCommand;
import com.acme.edu.command.StringCommand;
import com.acme.edu.saver.ConsoleSaver;

/**
 * Logger facade
 */
public class Logger {
    LoggerController controller = new LoggerController(new ConsoleSaver());

    public void log(int message) {
        controller.log(new IntCommand(message));
    }

    public void log(String message) {
        controller.log(new StringCommand(message));
    }

    public void flush() {
        controller.flush();
    }
}
