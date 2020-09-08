package com.acme.edu.controller;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.message.Type;
import com.acme.edu.saver.ConsoleSaver;

public class LoggerController {
    private ConsoleSaver loggerSaver;
    private LoggerCommand currentLoggerCommand;

    private static String previousType;
    private static String previousPrefix;

    public LoggerController(ConsoleSaver loggerSaver) {
        this.loggerSaver = loggerSaver;
    }

    public void log(LoggerCommand newLoggerCommand) {
        if (newLoggerCommand.isSameType(this.currentLoggerCommand)) {
            this.currentLoggerCommand = currentLoggerCommand.accumulate(newLoggerCommand);
        } else {
            loggerSaver.saveMessage(newLoggerCommand.getMessage());
            this.currentLoggerCommand = newLoggerCommand;
        }
//        this.currentLoggerCommand = newLoggerCommand;
//        int diff = checkNumberAccumulatorOverflow(Integer.MAX_VALUE, intAccumulator, message);
//        if (Integer.MAX_VALUE - intAccumulator < message) {
//            intAccumulator += diff;
//            message -= diff;
//            flush();
//        }
    }

    public static void flush() {
        String buffer = "";
        switch (previousType) {
            case Type.INT:
                buffer = currentLoggerCommand.clearBuffer();
                break;
//            case Type.STRING:
//                buffer = clearStringBuffer();
//                break;
//            case Type.BYTE:
//                buffer = clearByteBuffer();
//                break;
        }
        writeMessage(previousPrefix + buffer);
        setPreviousPrefixAndType(null, null);
    }
}
