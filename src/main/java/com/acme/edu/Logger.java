package com.acme.edu;

import com.acme.edu.buffer.Buffer;
import com.acme.edu.commands.arrays.ArrayIntCommand;
import com.acme.edu.commands.arrays.MatrixIntArrayCommand;
import com.acme.edu.commands.arrays.MultimatrixIntCommand;
import com.acme.edu.commands.types.*;
import com.acme.edu.commands.types.primitive.BooleanCommand;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.saver.ConsoleSaver;



public class Logger {
    private static LoggerController loggerController = new LoggerController(new ConsoleSaver(), new Buffer());

    public static void log(Object message) { loggerController.handleCommand(new ReferenceCommand(message)); }

    public static void log(char message) { loggerController.handleCommand(new CharCommand(message)); }

    public static void log(boolean message) { loggerController.handleCommand(new BooleanCommand(message)); }

    public static void log(byte message) { loggerController.handleCommand(new ByteCommand(message)); }

    public static void log(int message) { loggerController.handleCommand(new IntCommand(message)); }

    public static void log(String message) { loggerController.handleCommand(new StringCommand(message)); }

    public static void log(int [] array) { loggerController.handleCommand(new ArrayIntCommand(array)); }

    public static void log(int [][] array) { loggerController.handleCommand(new MatrixIntArrayCommand(array)); }

    public static void log(int[][][][] array) { loggerController.handleCommand(new MultimatrixIntCommand(array)); }

    public static void log(String... messages) {
        for(String message: messages) {
            loggerController.handleCommand(new StringCommand(message));
        }
    }

    public static void log(Integer... messages) {
        for(int message: messages) {
            loggerController.handleCommand(new IntCommand(message));
        }
    }

    public static void closeLogger() { loggerController.close(); }
}


