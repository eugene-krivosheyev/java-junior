package com.acme.edu;

import com.acme.edu.commands.Command;

public class LoggerController {
    private SuperSaver saver;
    private Accumulator accumulator = new Accumulator();
    Command currentState = null;

    //    public LoggerController(SuperFilter filter, SuperSaver saver) {
    public LoggerController() {
        this.saver = new ConcoleSaver();
    }

    public void log(Command command) {
        if (command.isTypeEqual(currentState) && !command.isSaveRequired(currentState)) {
            command.accumulate(currentState);
        } else if (currentState != null) {
            saver.save(currentState.getDecorated());
        }
        currentState = command;
    }

    public void flush() {
        saver.save(currentState.getDecorated());
    }
}
