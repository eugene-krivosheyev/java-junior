package com.acme.edu;

import com.acme.edu.commands.*;
import com.acme.edu.commands.numeric.ByteCommand;
import com.acme.edu.commands.numeric.IntCommand;
import com.acme.edu.savers.ConsoleSaver;
import com.acme.edu.savers.Saver;

public class Logger {
    private static final String PRIMITIVES_PREFIX = "primitives ";
    public static final String PR_ARRAY_PREFIX = PRIMITIVES_PREFIX + "array: ";
    public static final String PR_MATRIX_PREFIX = PRIMITIVES_PREFIX + "matrix: ";
    public static final String PR_MULTIMATRIX_PREFIX = PRIMITIVES_PREFIX + "multimatrix: ";

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

    // TODO: Refactor vector logging!
    public static void log(int[] array) {
        saver.save(PR_ARRAY_PREFIX + PrintUtils.arrayToString(array));
    }

    public static void log(int[][] array) {
        saver.save(PR_MATRIX_PREFIX + PrintUtils.arrayToString(array));
    }

    public static void flush() {
        loggerController.flush();
    }
}
