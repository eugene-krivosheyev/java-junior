package com.acme.edu;

public class LoggerController {
    private SuperAccumulator accumulator;
    private SuperSaver saver;
    private Command currentState = null;

    public LoggerController(SuperAccumulator accumulator, SuperSaver saver) {
        this.accumulator = accumulator;
        this.saver = saver;
    }

    Command getCurrentState() {
        return currentState;
    }

    public void log(Command command) {
        if (command.isTypeEquals(currentState)) {
            currentState = currentState.accumulate(command);
        } else {
            if (currentState != null) {
                flush();
            }
            currentState = command;
        }
    }

    void flush() {
        saver.save(currentState.getDecorated());
        currentState = null;
    }
}
