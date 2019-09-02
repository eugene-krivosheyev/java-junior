package com.acme.edu.mylogger;

import com.acme.edu.mylogger.accumulators.SuperAccumulator;
import com.acme.edu.mylogger.commands.Command;
import com.acme.edu.mylogger.savers.SuperSaver;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerController {
    private static final Logger LOGGER = Logger.getLogger(LoggerController.class.getName());
    private SuperAccumulator accumulator;
    private SuperSaver saver;
    private Command currentState = null;
    private Queue<Command> commandQueue;

    public LoggerController(SuperAccumulator accumulator, SuperSaver saver) {
        this.accumulator = accumulator;
        this.saver = saver;
        this.commandQueue = new LinkedList<>();
    }

    Command getCurrentState() {
        return currentState;
    }

    public void log(Command command) {
        if (command.isTypeEquals(currentState)) {
            try {
                accumulator.addToQueue(command);
            } catch (ArithmeticException e) {
                LOGGER.log(Level.SEVERE, "Overflow", e);
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

    public void flush() {
        try {
            accumulator.accumulate(commandQueue).ifPresent(e -> {
                try {
                    saver.save(e.getDecorated());
                } catch (IOException ex) {
                    LOGGER.log(Level.SEVERE, "IOException", e);
                }
            });
        } catch (ArithmeticException e) {
            LOGGER.log(Level.SEVERE, "Overflow", e);
        }
        currentState = null;
        commandQueue.clear();
        accumulator.clearQueue();
    }
}
