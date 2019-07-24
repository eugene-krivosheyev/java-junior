package com.acme.edu.command;

import com.acme.edu.Type;
import com.acme.edu.saver.ConsoleLoggerSaver;

import java.io.IOException;

public class IntMas2Command implements Command {
    private int[][] message ;
    private ConsoleLoggerSaver saver = null;
    private Command prevCommand = null ;

    public IntMas2Command(int[][] message) {
        this.message = message;
    }

    @Override
    public void accumulate(Command command, ConsoleLoggerSaver saver) throws IOException {
        this.saver = saver;
        if (command instanceof NoneCommand) {
            prevCommand = this;
        } else {
            prevCommand = command;
            flush();
        }
    }

    public String messageDecorate() {
        String str = "primitives matrix: {" + System.lineSeparator();
        for (int[] i : message) {
            str = str + "{";
            for (int j : i) {
                str += j + ", ";
            }
            if (i.length > 0)
                str = str.substring(0, str.length() - 2) + "}" + System.lineSeparator();
            else
                str +="}" + System.lineSeparator();
        }
        str += "}";
        return str;
    }

    @Override
    public void flush() throws IOException {
        saver.save(prevCommand.messageDecorate());
        prevCommand = this;
    }

    @Override
    public Command getPrevCommand() {
        return prevCommand;
    }
}
