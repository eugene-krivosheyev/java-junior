package com.acme.edu;

import com.acme.edu.command.*;
import com.acme.edu.save.Saver;

public class LoggerController {

    public static int INT_BUFFER = 0;
    public static int BYTE_BUFFER = 0;
    public static int STRING_BUFFER = 0;
    public static String PREVIOUS_TYPE = "";
    public static String PREVIOUS_STRING = "";
    public static String PREVIOUS_MESSAGE = "";

    private final Saver saver;
    private Command currentCommand = new Command() {
        @Override
        public String decorate() {
            return null;
        }
        @Override
        public boolean isSameType(Command cmd) {
            return true;
        }
        @Override
        public Command reduce(Command cmd) {
            return cmd;
        }
    };

    public LoggerController(Saver saver) {
        this.saver = saver;
    }
/*
    public static void log(IntCommand cmd) {
        if (Integer.MAX_VALUE - cmd.message < INT_BUFFER) {
            flushBuffers();
        }
        INT_BUFFER += cmd.message;
        if (!PREVIOUS_TYPE.equals(getClassName(cmd.message))) {
            flushBuffers();
        }
        PREVIOUS_TYPE = getClassName(cmd.message);
    }

    public static void log(StringCommand cmd) {
        if (!PREVIOUS_TYPE.equals(getClassName(cmd.message)) || !PREVIOUS_STRING.equals(cmd.message)) {
            flushBuffers();
        }
        if (PREVIOUS_STRING.equals(cmd.message)) {
            STRING_BUFFER += 1;
        }
        PREVIOUS_TYPE = getClassName(cmd.message);
        if (STRING_BUFFER == 0) {
            PREVIOUS_STRING = cmd.message;
            PREVIOUS_MESSAGE = cmd.message;
            STRING_BUFFER++;
        }
    }

    public  void log(ByteCommand cmd) {
        if (Byte.MAX_VALUE - cmd.message < BYTE_BUFFER) {
            flushBuffers();
        }
        BYTE_BUFFER += cmd.message;
        if (!PREVIOUS_TYPE.equals(getClassName(cmd.message))) {
            flushBuffers();
        }
        PREVIOUS_TYPE = getClassName(cmd.message);
    }

    public static void log(CharCommand cmd) {
        printLogMessage(cmd.decorate());
    }

    public static void log(BooleanCommand cmd) {
        printLogMessage(cmd.decorate());
    }

    public static void log(ObjectCommand cmd) {
        printLogMessage(cmd.decorate());
    }

    public static void log(ArrayCommand cmd) {
        printLogMessage(cmd.decorate());
    }

    public static void log(MatrixCommand cmd) {
        printLogMessage(cmd.decorate());
    }
*/
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
