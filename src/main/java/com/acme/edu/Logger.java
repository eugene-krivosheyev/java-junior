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

    public static void log(Integer... messages) {
        for (Integer message : messages) {
            loggerController.submit(new IntCommand(message));
        }
    }

    public static void log(char message) {
        loggerController.submit(new CharCommand(message));
    }

    public static void log(String message) {
        loggerController.submit(new StringCommand(message));
    }

    public static void log(String... messages) {
        for (String message : messages) {
            loggerController.submit(new StringCommand(message));
        }
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

    public static void main(String[] args) {
        Logger.log(123);
        Logger.log(321);
        Logger.log((byte) 100);
        Logger.log('P');
        Logger.log((byte) 11);
        Logger.log(Byte.MAX_VALUE);
        Logger.log((byte) 120);
        Logger.log((byte) 1);
        Logger.log("Yusuf");
        Logger.log("BASHA");
        Logger.log("BASHA");
        Logger.log("BASHA");
        Logger.log("smth");
        Logger.log('A');
        Logger.log("smth");
        Logger.log("smth");
        Logger.log(new int[]{-1, 0, 1});
        Logger.log(new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        Logger.log("str1", "string 2", "str 3");
        Logger.log(-1, 0, 1, 3);
        Logger.flush();
    }
}
