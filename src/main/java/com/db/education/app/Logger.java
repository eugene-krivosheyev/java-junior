package com.db.education.app;

public class Logger {
    public static void log(Object message) {
        String className = message.getClass().getTypeName();
        String outputType;
        switch (className) {
            case "java.lang.Integer":
            case "java.lang.Byte":
            case "java.lang.Boolean":
                outputType = "primitive";
                break;
            case "java.lang.Character":
                outputType = "char";
                break;
            case "java.lang.String":
                outputType = "string";
                break;
            default:
                outputType = "reference";
                break;
        }
        printLogMessage(outputType, message);
    }

    private static void printLogMessage(String type, Object obj) {
        System.out.print(type + ": " + obj + '\n');
    }
}
