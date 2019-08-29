package com.acme.edu;

import com.acme.edu.commands.Command;
import com.acme.edu.overflow.OverflowException;
import com.acme.edu.saver.Saver;
import com.acme.edu.saver.SaverException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LoggerController {
    private Saver saver;
    private StateCommand state;
    private List<Command> buffer;


    public LoggerController(Saver saver) {
        this.saver = saver;
        this.buffer = new LinkedList<>();
        this.state = StateCommand.NONE;
    }

    public void handleCommand(Command command) throws SaverException {
        try {
            if(this.state != command.getState())
                flush(command.getState());
            addCommand(command);
        } catch (Exception e) {
            throw new SaverException(e);
        }
    }

    private void addCommand(Command newCommand) { buffer.add(newCommand); }

    private void flush(StateCommand state) throws OverflowException {
        if (buffer.size() != 0) {
            buffer.forEach(cr -> saver.saveWithPrefix(cr));
            Command curCommand = buffer.get(0);
            for (int i = 1; i < buffer.size(); i++)
                curCommand = curCommand.accumulate(buffer.get(i));
            saver.saveWithoutPrefix(curCommand);
            buffer = new LinkedList<>();
        }
        this.state = state;
    }

    public void close() throws OverflowException { flush(StateCommand.NONE); }

}
