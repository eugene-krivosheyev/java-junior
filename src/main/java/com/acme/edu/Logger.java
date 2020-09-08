package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.saver.LogSaver;

import java.util.ArrayList;

/**
 * This is a simple logger for some standard Java types.
 * @version 1.0.2
 */
public class Logger {
    static LogSaver saver = new LogSaver();
    static ArrayList<Object> listOfLog = new ArrayList<>();

    /**
     * @param  message  a value to be logged
     */
    public static void log(int message) {
        listOfLog.add(message);
    }

    public static void log(byte message) {
        listOfLog.add(message);
    }

    public static void log(String message) {
        listOfLog.add(message);
    }

    public static void log(char message) {
        saver.save(new CharMessage(message));
    }

    public static void log(Object message) {
        saver.save(new ReferenceMessage(message));
    }

    public static void log(boolean message) {
        saver.save(new BoolMessage(message));
    }


    /**
     * Section for flush interface
     */
    public static void flushStart() {
        Object firstToLog = listOfLog.get(0);

        if (firstToLog instanceof Integer) {
            saver.save(new IntMessage(listOfLog));
        } else if (firstToLog instanceof Byte) {
            saver.save(new ByteMessage(listOfLog));
        } else if (firstToLog instanceof String) {
            saver.save(new StringMessage(listOfLog));
        }
        listOfLog.clear();
    }


     /*
    static final String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
    static final String PRIMITIVE_MATRIX_PREFIX = "primitives matrix: ";
    static final String PRIMITIVE_MULTIMATRIX_PREFIX = "primitives multimatrix: ";
*/
 /*

    public static void log(int[] message) {
        saver.save(
                PRIMITIVE_ARRAY_PREFIX,
                Arrays.toString(message)
        );
    }

    public static void log(int[][] message) {
        saver.save(
                PRIMITIVE_MATRIX_PREFIX,
                Arrays.deepToString(message).replace("], ", "]" + lineSeparator())
        );
    }

    public static void log(int[][][][] message) {
        saver.save(
                PRIMITIVE_MULTIMATRIX_PREFIX,
                Arrays.deepToString(message)
                        .replace("]", lineSeparator() + "]")
                        .replace("[", "[" + lineSeparator())
        );
    }
*/

}