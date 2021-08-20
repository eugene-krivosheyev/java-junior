package com.db.edu;

import com.db.edu.commands.BooleanCommand;
import com.db.edu.commands.ByteCommand;
import com.db.edu.commands.CharCommand;
import com.db.edu.commands.Command;
import com.db.edu.commands.IntCommand;
import com.db.edu.commands.ObjectCommand;
import com.db.edu.commands.StartCommand;
import com.db.edu.commands.StringCommand;

import java.io.IOException;
import java.io.OutputStream;

public class Logger {

    private static OutputStream DEFAULT_OUT = System.out;
    private static Command last = new StartCommand();

    private Logger() {
    }


    public static OutputStream getDefaultOut() {
        return DEFAULT_OUT;
    }

    public static void setDefaultOut(OutputStream defaultOut) {
        DEFAULT_OUT = defaultOut;
    }

    public static void log(int message) {
        Logger.processCommand(new IntCommand(message));
    }

    public static void log(byte message) {
        Logger.processCommand(new ByteCommand(message));
    }

    public static void log(char message) {
        Logger.processCommand(new CharCommand(message));
    }

    public static void log(String message)  {
        Logger.processCommand(new StringCommand(message));
    }

    public static void log(boolean message) {
        Logger.processCommand(new BooleanCommand(message));
    }

    public static void log(Object message) {
        Logger.processCommand(new ObjectCommand(message));
    }

    public static void flush() {
        last.finishCommand();
        writeMessage(last.getLogMessage());
        last = new StartCommand();
    }

    private static void processCommand(Command command) {
        Command next = last.accumulate(command);
        if (next != last) {
            writeMessage(last.getLogMessage());
            last = next;
        }
    }

    private static void writeMessage(String message) {
        try {
            DEFAULT_OUT.write(message.getBytes());
        } catch (IOException e) {
            System.out.println("An error occurred during logging: " + e);
        }
    }

}
