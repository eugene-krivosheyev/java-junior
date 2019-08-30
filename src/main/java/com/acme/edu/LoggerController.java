package com.acme.edu;

import com.acme.edu.commands.Command;
import com.acme.edu.overflow.OverflowException;
import com.acme.edu.saver.Saver;
import com.acme.edu.saver.SaverException;
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
            if(state != command.getState())
                flush(command.getState());
            addCommand(command);
        } catch (Exception e) { throw new SaverException(e); }
    }

    private void addCommand(Command newCommand) { buffer.add(newCommand); }

    private void flush(StateCommand state) {
        buffer.forEach(cr -> saver.saveWithPrefix(cr));
        if (buffer.size() > 1) {
            Command curCommand = buffer.get(0);
            for (int i = 1; i < buffer.size(); i++) {
                try {
                    curCommand = curCommand.accumulate(buffer.get(i));
                } catch (OverflowException e) {
                    buffer.forEach(cr -> saver.saveWithoutPrefix(cr));
                    break;
                }
            }
            saver.saveWithoutPrefix(curCommand);
        }
        else if (buffer.size() == 1) saver.saveWithoutPrefix(buffer.get(0));

        buffer = new LinkedList<>();
        this.state = state;
    }

    public void close()  { flush(StateCommand.NONE); }

}
