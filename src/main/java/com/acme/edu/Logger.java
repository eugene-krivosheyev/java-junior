package com.acme.edu;

import com.acme.edu.controller.LogController;
import com.acme.edu.decorator.PrefixLoggerDecorator;
import com.acme.edu.loggerexceptions.SaverException;
import com.acme.edu.messagelog.ArrayIntMessage;
import com.acme.edu.messagelog.ByteMessage;
import com.acme.edu.messagelog.CharMessage;
import com.acme.edu.messagelog.IntMessage;
import com.acme.edu.messagelog.BooleanMessage;
import com.acme.edu.messagelog.MatrixIntMessage;
import com.acme.edu.messagelog.ObjectMessage;
import com.acme.edu.messagelog.StringMessage;
import com.acme.edu.saver.ConsoleLoggerSaver;

public final class Logger {
    private static LogController controller = new LogController(new ConsoleLoggerSaver(), new PrefixLoggerDecorator());

    private Logger(){}

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void setController(LogController controller) {
        Logger.controller = controller;
    }

    public static int flush(){
        try {
            controller.flush();
        } catch (SaverException e) {
            e.printStackTrace();
            return e.getCode();
        }
        return 0;
    }

    public static int log(byte message) {
        return controller.log(new ByteMessage(message));
    }

    public static int log(boolean message) {
        return controller.log(new BooleanMessage(message));
    }

    public static int log(char message) {
        return controller.log(new CharMessage(message));
    }

    public static int log(Object message) {
        return controller.log(new ObjectMessage(message));
    }

    public static int log(String message) {
        return controller.log(new StringMessage(message));
    }

    public static int log(int ... message) {
        return controller.log(new ArrayIntMessage(message));
    }

    public static int log(int [] ... message) {
        return controller.log(new MatrixIntMessage(message));
    }
}
