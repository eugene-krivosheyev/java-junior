package com.acme.edu;

import com.acme.edu.exception.FlushException;
import com.acme.edu.exception.LogException;
import com.acme.edu.exception.SaverException;
import com.acme.edu.message.*;
import com.acme.edu.saver.ConsoleSaver;

public class Logger {
    static LoggerController loggerController = new LoggerController((Message message) -> {
        System.out.println(message);
    });

    public static void flush() throws FlushException {
        loggerController.flush();
    }

    public static void log(int message) throws LogException {
        loggerController.log(new IntMessage(message));
    }

    public static void log(byte message) throws LogException {
        loggerController.log(new ByteMessage(message));
    }

    public static void log(int[] message) throws LogException {
        loggerController.log(new ArrayMessage(message));
    }

    public static void log(String message) throws LogException {
        loggerController.log(new StringMessage(message));
    }

    public static void log(boolean message) throws LogException { loggerController.log(new BoolMessage(message));}
}
