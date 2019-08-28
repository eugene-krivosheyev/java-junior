package com.acme.edu;

public class LoggerController {
    private SuperAccumulator accumulator;
    private SuperSaver saver;
    private Command currentState = null;

    LoggerController(SuperAccumulator accumulator, SuperSaver saver) {
        this.accumulator = accumulator;
        this.saver = saver;
    }

    Command getCurrentState() {
        return currentState;
    }

    void log(Command command) {
        if (command.isTypeEquals(currentState)) {
            if (currentState.accumulate(command).isOverflow()) {
                flush();
                currentState = command;
                throw new ArithmeticException();
            } else {
                currentState = currentState.accumulate(command);
                throw new ArithmeticException();
            }
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
