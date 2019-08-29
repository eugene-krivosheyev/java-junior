package com.acme.edu.mylogger;

import java.util.Collection;
import java.util.LinkedList;

public class LoggerController {
    private SuperAccumulator accumulator;
    private SuperSaver saver;
    private Command currentState = null;
    private Collection<Command> commandCollection;

    LoggerController(SuperAccumulator accumulator, SuperSaver saver) {
        this.accumulator = accumulator;
        this.saver = saver;
        this.commandCollection = new LinkedList<>();
    }

    Command getCurrentState() {
        return currentState;
    }

    void log(Command command) {
        if (command.isTypeEquals(currentState)) {
            /*
            try {
                currentState.accumulate(command);
            }
            catch (ArithmeticException e) {
                e.printStackTrace();
                flush();
                currentState = command;
            }
            finally {
                currentState = currentState.accumulate(command);
            }
             */
            currentState = command;
            commandCollection.add(command);
        } else {
            if (currentState != null) {
                flush();
            }
            currentState = command;
            commandCollection.add(command);
        }
    }

    void flush() {
        //saver.save(currentState.getDecorated());
        try {
            saver.save(new IntCommand(accumulator.accumulate(commandCollection)).getDecorated());
        }
        catch (ArithmeticException e) {
            saver.save(new IntCommand(accumulator.getPrevSum()).getDecorated());
            e.printStackTrace();
        }
        currentState = null;
        commandCollection.clear();
    }
}
