package com.acme.edu.mylogger;

import java.util.LinkedList;
import java.util.Queue;

public class LoggerController {
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
            /*
            try {
                currentState.accumulate(command);
            } catch (ArithmeticException e) {
                e.printStackTrace();
                flush();
                currentState = command;
            } finally {
                currentState = currentState.accumulate(command);
            }
             */
            currentState = command;
            commandQueue.add(command);
        } else {
            if (currentState != null) {
                flush();
            }
            currentState = command;
            commandQueue.add(command);
        }
    }

    void flush() {
        //saver.save(currentState.getDecorated());
        /*
        try {
            saver.save(new IntCommand(accumulator.accumulate(commandCollection)).getDecorated());
        } catch (ArithmeticException e) {
            saver.save(new IntCommand(accumulator.getPrevSum()).getDecorated());
            e.printStackTrace();
        }
         */
        //saver.save(accumulator.accumulate(commandCollection).getDecorated());
        accumulator.accumulate(commandQueue).ifPresent(e -> saver.save(e.getDecorated()));
        currentState = null;
        commandQueue.clear();
    }
}
