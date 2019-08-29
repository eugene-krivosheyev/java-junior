package com.acme.edu.mylogger;

import java.util.LinkedList;
import java.util.Queue;

class LoggerController {
    private SuperAccumulator accumulator;
    private SuperSaver saver;
    private Command currentState = null;
    private Queue<Command> commandQueue;

    LoggerController(SuperAccumulator accumulator, SuperSaver saver) {
        this.accumulator = accumulator;
        this.saver = saver;
        this.commandQueue = new LinkedList<>();
    }

    Command getCurrentState() {
        return currentState;
    }

    void log(Command command) {
        if (command.isTypeEquals(currentState)) {
            try {
                accumulator.addToQueue(command);
            } catch (ArithmeticException e) {
                e.printStackTrace();
                flush();
                currentState = command;
                accumulator.addToQueue(command);
            } finally {
                commandQueue.add(command);
                currentState = command;
            }
        } else {
            if (currentState != null) {
                flush();
            }
            currentState = command;
            commandQueue.add(command);
            accumulator.addToQueue(command);
        }
    }

    void flush() {
        try {
            accumulator.accumulate(commandQueue).ifPresent(e -> saver.save(e.getDecorated()));
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        currentState = null;
        commandQueue.clear();
        accumulator.clearQueue();
    }
}
