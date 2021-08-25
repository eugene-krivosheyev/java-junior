package com.db.edu;


import static com.db.edu.Prefix.*;

public class Logger {
    private static Controller controller;

    public void log(int message) {
        controller.log(new IntMessage(message));
    }

    public void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public void log(String message) {
        controller.log(new StringMessage(message));
    }

}