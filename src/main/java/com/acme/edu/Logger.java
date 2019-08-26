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



public class Logger {
    private static LoggerController loggerController = new LoggerController(new ConsoleSaver(), new Buffer());

    public static void log(Object message) { loggerController.addCommand(new ReferenceCommand(message)); }

    public static void log(char message) { loggerController.addCommand(new CharCommand(message)); }

    public static void log(boolean message) { loggerController.addCommand(new BooleanCommand(message)); }

    public static void log(byte message) { loggerController.addCommand(new ByteCommand(message)); }

    public static void log(int message) { loggerController.addCommand(new IntCommand(message)); }

    public static void log(String message) { loggerController.addCommand(new StringCommand(message)); }

    public static void log(int [] array) { loggerController.addCommand(new ArrayIntCommand(array)); }

    public static void log(int [][] array) { loggerController.addCommand(new MatrixIntArrayCommand(array)); }

    public static void log(int[][][][] array) { loggerController.addCommand(new MultimatrixIntCommand(array)); }

    public static void closeLogger() { loggerController.getBuffer().changeState(BufferState.NONE, null); }
}


