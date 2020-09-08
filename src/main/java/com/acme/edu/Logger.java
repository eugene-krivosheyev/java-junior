package com.acme.edu;

import com.acme.edu.message.AbstractMessage;
import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.lineSeparator;

/**
 * This is a simple logger for some standard Java types.
 * @version 1.0.2
 */
public class Logger {
    static LogSaver saver = new LogSaver();

   /* static final String CHAR_PREFIX = "char: ";
    static final String REFERENCE_PREFIX = "reference: ";
    static final String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
    static final String PRIMITIVE_MATRIX_PREFIX = "primitives matrix: ";
    static final String PRIMITIVE_MULTIMATRIX_PREFIX = "primitives multimatrix: ";
*/
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


    /**
     * Section for flush interface
     */
    public static void flushStart() {
        Object firstToLog = listOfLog.get(0);

        if (firstToLog instanceof Integer) {
            IntMessage messageProvider = new IntMessage(listOfLog);
            saver.save("", messageProvider.messageController.toString());
        } else if (firstToLog instanceof Byte) {
            ByteMessage messageProvider = new ByteMessage(listOfLog);
            saver.save("", messageProvider.messageController.toString());
        } else if (firstToLog instanceof String) {
            StringMessage messageProvider = new StringMessage(listOfLog);
            saver.save("", messageProvider.messageController.toString());
        }
        listOfLog.clear();
    }

 /*   public static void log(boolean message) {
        saver.save(PRIMITIVE_PREFIX, message);
    }

    public static void log(char message) {
        saver.save(CHAR_PREFIX, message);
    }
*/

 /*   public static void log(Object message) {
        saver.save(REFERENCE_PREFIX, message);
    }

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