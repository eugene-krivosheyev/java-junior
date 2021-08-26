package com.acme.edu.ooad;

import com.acme.edu.ooad.controller.LoggerController;
import com.acme.edu.ooad.message.*;
import com.acme.edu.ooad.saver.Saver;

public class Logger {
    private LoggerController controller;

    public Logger(Saver saver){
        controller = new LoggerController(saver);
    }
    public void flush() {
        controller.flush();
    }

    public void log(int message) {
        controller.log(new IntegerMessage(message));
    }

    public void log(int... integers) {
        for ( var integer: integers ) {
            controller.log(new IntegerMessage(integer));
        }
    }

    public void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public void log(char message) {
        controller.log(new CharMessage(message));
    }

    public void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public void log(String message) {
        controller.log(new StringMessage(message));
    }

    public void log(String... strings) {
        for ( var string : strings ) {
            controller.log(new StringMessage(string));
        }
    }

    public void log(Object message) {
        controller.log(new ObjectMessage(message));
    }

}
