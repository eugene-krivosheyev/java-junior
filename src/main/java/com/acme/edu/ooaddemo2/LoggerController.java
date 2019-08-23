package com.acme.edu.ooaddemo2;

public class LoggerController {
    private SuperFilter filter;
    private SuperSaver saver;
    private Command currentState = null;

    public LoggerController(SuperFilter filter, SuperSaver saver) {
        this.filter = filter;
        this.saver = saver;
    }

    public void log(Command command) {
        if (currentState.isTypeEquals(command)) {
            currentState = currentState.accumulate(command);
        } else {
            saver.save(command.getDecorated());
            currentState = command;
        }

        if (!filter.isFiltered(command)) {
            saver.save(command.getDecorated());
        }
    }
}
