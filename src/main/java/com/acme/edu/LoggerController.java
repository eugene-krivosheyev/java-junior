package com.acme.edu;

import com.acme.edu.command.*;
import com.acme.edu.save.Saver;

public class LoggerController {

    private final Saver saver;
    private Command currentCommand = new Command() {
        @Override
        public String decorate() {
            return null;
        }
        @Override
        public boolean isSameType(Command cmd) {
            return false;
        }
        @Override
        public Command reduce(Command cmd) {
            return cmd;
        }
    };

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void flushBuffers() {
        /*switch (PREVIOUS_TYPE) {
            case "String":
                if (STRING_BUFFER > 1) {
                    printLogMessage(StringCommand.STRING_PREFIX + PREVIOUS_STRING + " (x" + STRING_BUFFER + ")");
                } else
                    printLogMessage(StringCommand.STRING_PREFIX + PREVIOUS_STRING);
                flushString();
                break;
            case "Integer":
                printLogMessage(PrimitiveCommand.PRIMITIVE_PREFIX + INT_BUFFER);
                INT_BUFFER = 0;
                break;
            case "Byte":
                printLogMessage(PrimitiveCommand.PRIMITIVE_PREFIX + BYTE_BUFFER);
                BYTE_BUFFER = 0;
                break;
        }*/
        saver.save(currentCommand);
    }

    public void log(Command cmd) {
        if (currentCommand.isSameType(cmd)) {
            currentCommand = currentCommand.reduce(cmd);
        }
        else {
            saver.save(currentCommand);
            currentCommand = cmd;
        }
    }

}
