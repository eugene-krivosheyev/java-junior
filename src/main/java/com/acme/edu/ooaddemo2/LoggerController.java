package com.acme.edu.ooaddemo2;

public class LoggerController {
    private SuperFilter filter;
    private SuperSaver saver;
    private Command currentState = null;

    public LoggerController(SuperFilter filter, SuperSaver saver) {
        this.filter = filter;
        this.saver = saver;
    }

    Command getCurrentState() {
        return currentState;
    }

    public void log(Command command) {
        if (command.isTypeEquals(currentState)) {
            currentState = currentState.accumulate(command);
        } else {
            currentState = command;
            if (!filter.isFiltered(command)) {
                saver.save(command.getDecorated());
            }
        }
    }
}
