package com.acme.edu;

import com.acme.edu.commands.Command;
import com.acme.edu.overflow.OverflowException;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.Saver;
import com.acme.edu.saver.SaverException;

public class LoggerController {
    private Saver saver;
    private Command currentCommand = null;
    private StateCommand state = StateCommand.NONE;


    public LoggerController(Saver saver) { this.saver = saver; }

    public void handleCommand(Command command) throws SaverException {
        try {
            changeState(command);
            saver.saveWithPrefix(command);
        } catch (Exception e) {
            throw new SaverException(e);
        }
    }

    private void addCommand(Command newCommand) throws OverflowException {
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

    private void changeState(Command command) throws OverflowException {
        if(getState() != command.getState()) {
            flush(command.getState());
        }
        addCommand(command);
    }

    private StateCommand getState() { return state; }

    public void close() { flush(StateCommand.NONE); }

}
