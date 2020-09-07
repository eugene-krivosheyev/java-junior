package com.acme.edu;

public class LogPrinter {
    private static String final_log = "";

    private static void print(String prefix, Object postfix) {
        final_log = final_log + (prefix + postfix) + System.lineSeparator();
    }

    public static void print(String prefix)
    {
        final_log = final_log + prefix + System.lineSeparator();
    }
}
