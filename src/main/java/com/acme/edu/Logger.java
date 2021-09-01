package com.acme.edu;

import com.acme.edu.exceptions.FileSaverException;
import com.acme.edu.filters.LengthFilter;
import com.acme.edu.messages.*;
import com.acme.edu.savers.ConsoleSaver;
import com.acme.edu.savers.FileSaver;

public class Logger {
    private LoggerController controller;

    public Logger() {
        try {
            controller  = new LoggerController(
                    new FileSaver("results.txt", "Windows-1251", 4096),
                    new LengthFilter(25)
            );
        } catch (FileSaverException e) {
            System.out.println("exception: " + e.getMessage());
            System.exit(-1);
        }
    }

    public void log(int message) {
        controller.log(new IntMessage(message));
    }

    public void log(int ... params) {
        for (int temp : params) {
            controller.log(new IntMessage(temp));
        }
    }

    public void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public void log(char message) {
        controller.log(new CharMessage(message));
    }

    public void log(String message) {
        controller.log(new StringMessage(message));
    }

    public void log(String ... params){
        for (String temp : params) {
            controller.log(new StringMessage(temp));
        }

    }

    public void log(boolean message) {
        controller.log(new BoolMessage(message));
    }

    public void log(Object message) {
        controller.log(new ObjectMessage(message));
    }

    public void flush() {
        controller.flush();
    }

    public void close() {
        controller.close();
    }
}
