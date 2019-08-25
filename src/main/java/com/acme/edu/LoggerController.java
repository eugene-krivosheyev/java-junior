package com.acme.edu;

/**
 * Created by kate-c on 23/08/2019.
 */
public class LoggerController {
    Saver saver = new ConsoleSaver();
    Command previousCommand = null;

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
            CommandWrapper result = previousCommand.accumulate(newCommand);
            if (result.shouldBeFlushed) {
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
