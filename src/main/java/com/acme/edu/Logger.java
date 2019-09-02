package com.acme.edu;

import com.acme.edu.commands.*;
import com.acme.edu.commands.numeric.ByteCommand;
import com.acme.edu.commands.numeric.IntCommand;
import com.acme.edu.commands.vector.IntArrayCommand;
import com.acme.edu.commands.vector.IntMatrixCommand;
import com.acme.edu.savers.ConsoleSaver;
import com.acme.edu.savers.Saver;

public class Logger {
    //    private static final Saver saver = new FileSaver("file.txt");
    private static final Saver saver = new ConsoleSaver();
    private static final LoggerController loggerController = new LoggerController(saver);

    public static void log(byte message) {
        loggerController.submit(new ByteCommand(message));
    }

    public static void log(int message) {
        loggerController.submit(new IntCommand(message));
    }

    public static void log(char message) {
        loggerController.submit(new CharCommand(message));
    }

    public static void log(String message) {
        loggerController.submit(new StringCommand(message));
    }

    public static void log(int[] message) {
        loggerController.submit(new IntArrayCommand(message));
    }

    public static void log(int[][] message) {
        loggerController.submit(new IntMatrixCommand(message));
    }

    public static void flush() {
        loggerController.flush();
    }
}
