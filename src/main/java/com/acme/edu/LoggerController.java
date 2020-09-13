package com.acme.edu;

import com.acme.edu.command.*;
import com.acme.edu.exceptions.LogException;
import com.acme.edu.save.Saver;

public class LoggerController {

    private final Saver saver;
    private Command currentCommand;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void flushBuffers() {
        if (currentCommand!= null)
            saver.save(currentCommand);
        currentCommand = null;
    }

    public void log(Command cmd) throws LogException{
        try {
            if (currentCommand != null && currentCommand.isSameType(cmd) && !currentCommand.isOverflow(cmd)) {
                currentCommand = currentCommand.reduce(cmd);
            }
            else {
                if (currentCommand != null)
                    saver.save(currentCommand);
                currentCommand = cmd;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());  // + " : " + e.getType()
        }
    }

    public Command getCurrentCommand() {
        return currentCommand;
    }


}
