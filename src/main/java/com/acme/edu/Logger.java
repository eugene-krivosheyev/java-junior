package com.acme.edu;

import com.acme.edu.Decorator.Decorator;
import com.acme.edu.controller.Controller;
import com.acme.edu.controller.LogOperationException;
import com.acme.edu.message.*;

import static com.acme.edu.Decorator.IntegerDecorator.INTEGER;

public class Logger {

    private static Controller controller = new Controller();

    public static int log(int message) throws LogOperationException {
        return controller.log(new IntMessage(message));
    }

    public static int log(int message, Decorator decorator) throws LogOperationException {
        return controller.log(new IntMessage(message,
                (Message elem) -> INTEGER + ((IntMessage) elem).getValue())
        );
    }

    public static int log(char message) throws LogOperationException {
        return controller.log(new CharMessage(message));
    }

    public static int log(byte message) throws LogOperationException {
        return controller.log(new ByteMessage(message));
    }

    public static int log(String message) throws LogOperationException {
        return controller.log(new StringMessage(message));
    }

    public static int log(boolean message) throws LogOperationException {
        return controller.log(new BooleanMessage(message));
    }

    public static int log(Object message) throws LogOperationException {
        return controller.log(new ObjectMessage(message));
    }

    public static void flush() throws LogOperationException{
        controller.flush();
    }
}


