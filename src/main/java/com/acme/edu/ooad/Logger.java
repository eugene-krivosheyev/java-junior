package com.acme.edu.ooad;

import java.io.File;

public class Logger {
    //Field DI
    private final LogFilter filter; //IS-A
    private final LogSaver saver;
    private Command state;

    //Constructor DI
    public Logger(LogFilter filter, LogSaver saver) {
        this.filter = filter;
        this.saver = saver;
    }

    public void log(Command message) {
        if (filter.allow(message)) {
            saver.save(message);
        }
    }


    public static void main(String[] args) {
        Command message = new Command("");
        if (message instanceof StringCommand) {
            StringCommand sc = (StringCommand) message;
            sc.strMethod();
        }
    }
}
