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
import java.util.Arrays;
import java.util.stream.Collectors;

public class Logger {

    private static OutputStream DEFAULT_OUT = System.out;
    private static Command lastCommand = new StartCommand();

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

    public static void log(String message) {
        Logger.processCommand(new StringCommand(message));
    }

    public static void log(boolean message) {
        Logger.processCommand(new BooleanCommand(message));
    }

    public static void log(int... message) {
        Arrays.stream(message).forEach(msg -> Logger.processCommand(new IntCommand(msg)));
    }

    public static void log(String... message) {
        Arrays.stream(message).forEach(msg -> Logger.processCommand(new StringCommand(msg)));
    }

    public static void log(Object message) {
        Logger.processCommand(new ObjectCommand(message));
    }

    public static void flush() {
        lastCommand.finishCommand();
        writeMessage(lastCommand.getLogMessage());
        lastCommand = new StartCommand();
    }

    private static void processCommand(Command command) {
        Command curCommand = lastCommand.accumulate(command);
        if (curCommand != lastCommand) {
            writeMessage(lastCommand.getLogMessage());
            lastCommand = curCommand;
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
