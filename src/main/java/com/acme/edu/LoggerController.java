package com.acme.edu;

import com.acme.edu.commands.Command;
import com.acme.edu.overflow.OverflowException;
import com.acme.edu.saver.Saver;
import com.acme.edu.saver.SaverException;
import java.util.LinkedList;
import java.util.Queue;

public class LoggerController {
    private Saver saver;
    private StateCommand state;
    private Queue<Command> buffer;


    public LoggerController(Saver saver) {
        this.saver = saver;
        this.buffer = new LinkedList<>();
        this.state = StateCommand.NONE;
    }

    public void handleCommand(Command command) throws SaverException {
        try {
            if(state != command.getState())
                flush(command.getState());
            addCommand(command);
        } catch (Exception e) { throw new SaverException(e); }
    }

    private void addCommand(Command newCommand) { buffer.add(newCommand); }

    private void flush(StateCommand state) throws SaverException {
        if (buffer.size() != 0) {
            buffer.forEach(cr -> saver.saveWithPrefix(cr));
            saver.saveWithoutPrefix(buffer.stream().reduce((c, c1) -> {
                try {
                    return c.accumulate(c1);
                } catch (OverflowException e) { e.printStackTrace(); }
                return null;
            }).orElseThrow(() -> new SaverException("Error in saver!")));
            buffer = new LinkedList<>();
        }
        this.state = state;
    }

    public void close() throws SaverException { flush(StateCommand.NONE); }

}
