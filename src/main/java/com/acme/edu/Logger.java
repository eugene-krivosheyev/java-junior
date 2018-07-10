package com.acme.edu;

public class Logger {



    private static int previous = 0;
    private static int value = 0;

    private static String previousString;
    private static int numberOfStrings = 0;

    public static void flush() {
        if (previous > 0) {
            System.out.print("primitive: " + value + "\n");
            previous = 0;
            value = 0;
        }
    }



    public static void log(int message) {
        previous++;
        value = value + message;
    }

    public static void log(byte message) {
        flush();
        System.out.println("primitive: " + message);
    }

    public static void log(char message) {
        flush();
        System.out.print("char: " + message + "\n");
    }

    public static void log(String message) {
        flush();
        if (previousString == null){
            previousString = message;
        }
        if (previousString.equals(message)){
            numberOfStrings++;
        }
        if (!previousString.equals(message)){
            System.out.print("string: " + message);
            if (numberOfStrings > 1){
                System.out.println("(x" + numberOfStrings + ")");
            }
            System.out.println("\n");
        }

    }

    public static void log(boolean message) {
        flush();

        Message<Boolean> booleanMessage = new Message<>(message);
        new Logger();
        log(booleanMessage);
    }

    public static void log(Object object) {
        flush();
        System.out.print("reference: : " + object.toString() + "\n");
    }

    public void log(TestMessage testMessage){
        testMessage.print();
    }
}
