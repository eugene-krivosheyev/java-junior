package com.acme.edu;

import com.acme.edu.commands.Command;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.Saver;

public class LoggerController {
    private Saver saver;
    private Command currentCommand = null;
    private StateCommand state = StateCommand.NONE;


    public LoggerController(Saver saver) { this.saver = saver; }

    public void handleCommand(Command command) {
        changeState(command);
        saver.saveWithPrefix(command);
    }

    private void addCommand(Command newCommand) {
        if (currentCommand == null) {
            currentCommand = newCommand;
        } else currentCommand = currentCommand.accumulate(newCommand);
    }

    private void flush(StateCommand state) {
        if (currentCommand !=null) {
            new ConsoleSaver().saveWithoutPrefix(currentCommand);
            currentCommand = null;
        }
        this.state = state;
    }

    private void changeState(Command command) {
        if(getState() != command.getState()) {
            flush(command.getState());
        }
        addCommand(command);
    }

    private StateCommand getState() { return state; }

    public void close() { flush(StateCommand.NONE); }

}
