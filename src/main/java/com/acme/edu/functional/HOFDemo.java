package com.acme.edu.functional;

import com.acme.edu.expressionproblem.message.IntMessage;
import com.acme.edu.expressionproblem.message.Message;

import java.util.function.Supplier;

public class HOFDemo {
    private static Message result;

    public static void main(String[] args) {

    }

    public static void log(int message) {
        genericLog(
            message,
            Integer.MAX_VALUE, Integer.MIN_VALUE,
            () -> new IntMessage(message));
    }
    public static void log(byte message) {
        genericLog(
            message,
            Byte.MAX_VALUE, Byte.MIN_VALUE,
            () -> new ByteMessage(message)
        );
    }

    public static void genericLog(
            int message,
            int maxValue, int minValue,
            Supplier<Message> supplier)

    {
        if (message > maxValue) {
            result = supplier.get();
        } else if (message < minValue) {
            result = supplier.get();
        }
    }
}
