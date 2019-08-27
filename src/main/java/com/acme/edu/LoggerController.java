package com.acme.edu;

import com.acme.edu.commands.Command;
import com.sun.istack.internal.Nullable;

/**
 * Created by kate-c on 23/08/2019.
 */
public class LoggerController {
    private Saver saver = new ConsoleSaver();
    @Nullable private Command previousCommand = null;

    public LoggerController() { }

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void log(Command newCommand) {
        if (previousCommand == null) {
            previousCommand = newCommand;
            return;
        }

        if (previousCommand.isTypeEqual(newCommand)) {
            // TODO -> tell not ask
            CommandAndFlushOptional result = previousCommand.accumulate(newCommand);
            if (result.ifFlushNeeded()) {
                flush();
            }
            previousCommand = result.getCommand();
        } else {
            flush();
            previousCommand = newCommand;
        }
    }

    public void flush() {
        saver.save(previousCommand.decorate());
        previousCommand = null;
    }
}
