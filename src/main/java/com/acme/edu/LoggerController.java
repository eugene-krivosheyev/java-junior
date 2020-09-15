package com.acme.edu;

import com.acme.edu.command.*;
import com.acme.edu.exceptions.LogException;
import com.acme.edu.exceptions.SaveException;
import com.acme.edu.save.Saver;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.Arrays;

public class LoggerController {

    private final Iterable<Saver> savers;
    private Command currentCommand;

    public LoggerController(Saver... savers) {
        this.savers = Arrays.asList(savers);
    }

    public void flushBuffers() {
        if (currentCommand != null)
                savers.forEach(s -> {
                    try {
                        s.save(currentCommand);
                    } catch (IOException | SaveException e) {
                        e.printStackTrace();
                    }
                });
        currentCommand = null;
    }

    public void log(Command cmd) {
        try {
            if (currentCommand != null && currentCommand.isSameType(cmd) && !currentCommand.isOverflow(cmd)) {
                currentCommand = currentCommand.reduce(cmd);
            }
            else {
                if (currentCommand != null)
                    savers.forEach(s -> {
                        try {
                            s.save(currentCommand);
                        } catch (IOException | SaveException e) {
                            e.printStackTrace();
                        }
                    });
                currentCommand = cmd;
                if (cmd instanceof StringCommand) {
                    StringCommand.sameCommandCounter = 1;
                }
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
