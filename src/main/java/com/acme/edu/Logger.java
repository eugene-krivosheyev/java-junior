package com.acme.edu;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.lineSeparator;

/**
 * This is a simple logger for some standard Java types.
 * @version 1.0.2
 */
public class Logger {
    static final String CHAR_PREFIX = "char: ";
    static final String STRING_PREFIX = "string: ";
    static final String REFERENCE_PREFIX = "reference: ";
    static final String PRIMITIVE_PREFIX = "primitive: ";

    static List<Object> listOfLog = new ArrayList<>();

    static void prepareAndWriteMessage(String prefix, Object message) {
        System.out.println(prefix + message);
    }

    /**
     * @param  message  a value to be logged
     */
    public static void log(int message) {
        listOfLog.add(message);
    }

    public static void log(byte message) {
        listOfLog.add(message);
    }

    public static void log(boolean message) {
        prepareAndWriteMessage(PRIMITIVE_PREFIX, message);
    }

    public static void log(char message) {
        prepareAndWriteMessage(CHAR_PREFIX, message);
    }

    public static void log(String message) {
        listOfLog.add(message);
    }

    public static void log(Object message) {
        prepareAndWriteMessage(REFERENCE_PREFIX, message);
    }

    /**
     * Section for flush interface
     */
    public static void flushStart() {
        Object firstToLog = listOfLog.get(0);

        if (firstToLog instanceof Integer) {
            prepareAndWriteMessage(PRIMITIVE_PREFIX, sumInt());
        } else if (firstToLog instanceof Byte) {
            prepareAndWriteMessage(PRIMITIVE_PREFIX, sumByte());
        } else if (firstToLog instanceof String) {
            prepareAndWriteMessage("", sumStrings());
        }
        listOfLog.clear();
    }

    static int sumInt() {
        int resultIntSum = 0;
        for (Object currentValue : listOfLog) {
            if (Integer.MAX_VALUE - resultIntSum < (int) currentValue) {
                resultIntSum = (int) currentValue - (Integer.MAX_VALUE - resultIntSum);
                prepareAndWriteMessage(PRIMITIVE_PREFIX, Integer.MAX_VALUE);
            } else {
                resultIntSum += (int) currentValue;
            }
        }
        return resultIntSum;
    }

    static byte sumByte() {
        byte resultByteSum = 0;
        for (Object currentValue : listOfLog) {
            if (Byte.MAX_VALUE - resultByteSum < (byte) currentValue) {
                resultByteSum = (byte) ((byte) currentValue - (Byte.MAX_VALUE - resultByteSum));
                prepareAndWriteMessage(PRIMITIVE_PREFIX, Byte.MAX_VALUE);
            } else {
                resultByteSum += (byte) currentValue;
            }
        }
        return resultByteSum;
    }

    static String sumStrings() {
        String templateMultiple = STRING_PREFIX + "%s " + "(x%o)";
        String templateUnique = STRING_PREFIX + "%s";
        StringBuilder resultStringSum = new StringBuilder();
        String prevValue = (String) listOfLog.get(0);
        int counter = 0;

        for (int i = 0; i < listOfLog.size(); i++) {
            String currentValue = (String) listOfLog.get(i);
            if (i == listOfLog.size() - 1) {
                resultStringSum
                        .append(counter == 0 ?
                                String.format(templateUnique, currentValue) :
                                String.format(templateMultiple, currentValue, counter + 1));
            } else {
                if (currentValue.equals(prevValue)) {
                    counter += 1;
                } else {
                    resultStringSum
                            .append(counter == 1 ?
                                    String.format(templateUnique, prevValue) :
                                    String.format(templateMultiple, prevValue, counter))
                            .append(lineSeparator());
                }
                prevValue = currentValue;
            }
        }
        return resultStringSum.toString();
    }
}