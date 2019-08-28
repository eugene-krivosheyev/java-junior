package com.acme.edu;

import com.acme.edu.commands.Command;
import com.acme.edu.savers.ConsoleSaver;
import com.acme.edu.savers.Saver;
import org.jetbrains.annotations.Nullable;

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
            try {
                previousCommand = previousCommand.accumulate(newCommand, saver);
            }
            catch(IllegalArgumentException e) {
                e.printStackTrace();
            }
        } else {
            previousCommand.flush(saver);
            previousCommand = newCommand;
        }
    }

    public void flush() {
        previousCommand.flush(saver);
        previousCommand = null;
    }
}
