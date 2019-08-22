package com.acme.edu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Logger {

    // testability
    private final static String PRIMITIVE_PREFIX = "primitive: ";
    private final static String CHAR_PREFIX = "char: ";
    private final static String STRING_PREFIX = "string: ";
    private final static String REFERENCE_PREFIX = "reference: ";
    public static final String INTEGER_CLASS = "Integer";
    public static final String STRING_CLASS = "String";
    public static final String BYTE_CLASS = "Byte";

    private static List <Object> buffer = new ArrayList <>();
    private static String currentType = "";

    private static List <String> canSum = new ArrayList <>();

    private static HashMap <String, String> classPrefixMapping = new HashMap <>();

    static {
        canSum.add(INTEGER_CLASS);
        canSum.add(STRING_CLASS);
        canSum.add(BYTE_CLASS);

        // todo const
        classPrefixMapping.put(INTEGER_CLASS, PRIMITIVE_PREFIX);
        classPrefixMapping.put(BYTE_CLASS, PRIMITIVE_PREFIX);
        classPrefixMapping.put("Boolean", PRIMITIVE_PREFIX);
        classPrefixMapping.put("Char", CHAR_PREFIX);
        classPrefixMapping.put(STRING_CLASS, STRING_PREFIX);
        classPrefixMapping.put("Object", REFERENCE_PREFIX);
    }


    public static void log(int message) {
        save("Integer", message);
    }

    public static void log(byte message) {
        save(BYTE_CLASS, message);
    }

    public static void log(char message) {
        save("Char", message);
    }

    public static void log(String message) {
        save("String", message);
    }

    public static void log(Boolean message) {
        save("Boolean", message);
    }

    public static void log(Object message) {
        save("Object", message);
    }
    // todo pass param type

    private static void save(String type, Object message) {

        if (currentType.equalsIgnoreCase(type)) {
            buffer.add(message);
        } else {
            flushBuffer();
            buffer.add(message);
            currentType = type;
        }
    }

    private static void flushBuffer() {
        if (buffer.isEmpty())
            return;
        if (canSum.contains(currentType)) {
            if (currentType.equalsIgnoreCase(STRING_CLASS)) {
                Map <String, Long> bufferMap =
                        buffer.stream()
                                .map(e -> e.toString())
                                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
                for (String key : bufferMap.keySet()) {
                    long num = bufferMap.get(key);
                    System.out.print(STRING_PREFIX + key);
                    if (num == 1)
                        System.out.println();
                    else
                        System.out.println(" (x" + num + ")");
                }
            } else if (currentType.equalsIgnoreCase(INTEGER_CLASS)) {
                int sum = 0;
                for (Object elem : buffer) {
                    int diff = Integer.MAX_VALUE - sum;
                    if (diff > (int) elem) {
                        sum += (int) elem;
                    } else {
                        System.out.println(PRIMITIVE_PREFIX+sum);
                        sum = (int) elem;
                    }

                }
                System.out.println(PRIMITIVE_PREFIX + sum);
            } else if (currentType.equalsIgnoreCase(BYTE_CLASS)) {
                int sum = 0;
                for (Object elem : buffer) {
                    int diff = Byte.MAX_VALUE - sum;
                    if (diff > (byte) elem) {
                        sum += (byte) elem;
                    } else {
                        System.out.println(PRIMITIVE_PREFIX+sum);
                        sum = (byte) elem;
                    }
                }
                System.out.println(PRIMITIVE_PREFIX + sum);
            }

            buffer.clear();
        } else {
            System.out.println(classPrefixMapping.get(currentType) + buffer.get(0));
            buffer.clear();
        }

    }

    public static void flush() {

        flushBuffer();

    }

}
