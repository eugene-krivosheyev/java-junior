package com.acme.edu;

/**
 * Created by kate-c on 23/08/2019.
 */
public class LoggerController {
    Saver saver = new ConsoleSaver();
    Command previousCommand = null;

    public void log(Command command) {
        if (previousCommand == null) {
            previousCommand = command;
            return;
        }
        if (previousCommand.isTypeEqual(command)) {
            previousCommand = previousCommand.accumulate(command);
        } else {
            flush();
            previousCommand = command;
        }
    }

    public void flush() {
        previousCommand.cleanBuffer();
        saver.save(previousCommand.decorate());
    }
}
