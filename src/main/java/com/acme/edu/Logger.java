package com.acme.edu;


import com.acme.edu.buffer.Buffer;
import com.acme.edu.buffer.BufferState;
import com.acme.edu.commands.arrays.ArrayIntCommand;
import com.acme.edu.commands.arrays.MatrixIntArrayCommand;
import com.acme.edu.commands.arrays.MultimatrixIntCommand;
import com.acme.edu.commands.types.*;
import com.acme.edu.commands.types.primitive.BooleanCommand;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.saver.ConsoleSaver;

import static com.acme.edu.buffer.Buffer.addInBuffer;


public class Logger {

    private static Buffer buffer = Buffer.getInstance();

    private static LoggerController loggerController = new LoggerController(new ConsoleSaver());

    public static void log(Object message) { loggerController.getSaver().saveWithPrefix(new ReferenceCommand(message)); }

    public static void log(char message) { loggerController.getSaver().saveWithPrefix(new CharCommand(message)); }

    public static void log(boolean message) { loggerController.getSaver().saveWithPrefix(new BooleanCommand(message)); }

    public static void log(byte message) {
        buffer.changeState(BufferState.BYTE, () -> addInBuffer(message));
        loggerController.getSaver().saveWithPrefix(new ByteCommand(message));
    }

    public static void log(int message) {
        buffer.changeState(BufferState.INT, () -> addInBuffer(message));
        loggerController.getSaver().saveWithPrefix(new IntCommand(message));
    }

    public static void log(String message) {
        buffer.changeState(BufferState.STR, () -> addInBuffer(message));
        loggerController.getSaver().saveWithPrefix(new StringCommand(message));
    }

    public static void log(int [] array) { loggerController.getSaver().saveWithPrefix(new ArrayIntCommand(array)); }

    public static void log(int [][] array) { loggerController.getSaver().saveWithPrefix(new MatrixIntArrayCommand(array)); }

    public static void log(int[][][][] array) { loggerController.getSaver().saveWithPrefix(new MultimatrixIntCommand(array)); }

    public static void closeLogger() { buffer.changeState(BufferState.NONE, null); }


}


