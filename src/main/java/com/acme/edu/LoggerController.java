package com.acme.edu;

import com.acme.edu.commands.Command;
import com.acme.edu.overflow.OverflowException;
import com.acme.edu.saver.Saver;
import com.acme.edu.saver.SaverException;
import java.util.LinkedList;
import java.util.List;

public class LoggerController {
    private Saver saver;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public synchronized List<Command> handleCommand(Command command, List<Command> buffer) throws SaverException {
        try {
            if (buffer.size() != 0 && buffer.get(0).getState() != command.getState())
                buffer = flush(buffer);
            return addCommand(command, buffer);
        } catch (Exception e) { throw new SaverException(e); }
    }

    private List<Command> addCommand(Command newCommand, List<Command> buffer) {
        buffer.add(newCommand);
        return buffer;
    }

    private List<Command> flush(List<Command> buffer) throws SaverException{
        for(Command c: buffer) {
            saver.saveWithPrefix(c);
        }
        if (buffer.size() > 1) {
            Command curCommand = buffer.get(0);
            for (int i = 1; i < buffer.size(); i++) {
                try {
                    curCommand = curCommand.accumulate(buffer.get(i));
                } catch (OverflowException e) {
                    for(Command c: buffer) { saver.saveWithoutPrefix(c); }
                    break;
                }
            }
            saver.saveWithoutPrefix(curCommand);
        }
        else if (buffer.size() == 1) saver.saveWithoutPrefix(buffer.get(0));

        return new LinkedList<>();
    }

    public void close(List<Command> buffer) throws SaverException { flush(buffer); }

}
