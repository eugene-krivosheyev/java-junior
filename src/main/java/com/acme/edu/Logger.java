package com.acme.edu;


import com.acme.edu.model.MessageType;
import com.acme.edu.model.message.DefaultMessage;
import com.acme.edu.model.message.MessageWithCount;
import com.acme.edu.model.message.MessageWithSum;
import com.acme.edu.model.MessageContainer;


public class Logger {
    private static MessageContainer container = new MessageContainer();

    public static void log(int message) {
        if (container.isNotEmpty()
                && container.getLastMessage().getType().equals(MessageType.INT_TYPE)
                && ((MessageWithSum) container.getLastMessage()).isSumLessThanMaxValue(message, Integer.MAX_VALUE)) {
            container.getLastMessage().addValue(String.valueOf(message));
        } else {
            container.addMessage(new MessageWithSum(MessageType.INT_TYPE, String.valueOf(message)));
        }
    }

    public static void log(byte message) {
        if (container.isNotEmpty()
                && container.getLastMessage().getType().equals(MessageType.BYTE_TYPE)
                && ((MessageWithSum) container.getLastMessage()).isSumLessThanMaxValue(message, Byte.MAX_VALUE)) {
            container.getLastMessage().addValue(String.valueOf(message));
        } else {
            container.addMessage(new MessageWithSum(MessageType.BYTE_TYPE, String.valueOf(message)));
        }
    }
    public static void log(char message) {
        container.addMessage(new DefaultMessage(MessageType.CHAR_TYPE, String.valueOf(message)));
    }

    public static void log(String message) {
        if (container.isNotEmpty()
                && container.getLastMessage().getType().equals(MessageType.STRING_TYPE)
                && container.getLastMessage().getValue().equals(message)) {
            container.getLastMessage().addValue(message);
        } else {
            container.addMessage(new MessageWithCount(MessageType.STRING_TYPE, message));
        }
    }

    public static void log(boolean message) {
        container.addMessage(new DefaultMessage(MessageType.BOOLEAN_TYPE, String.valueOf(message)));
    }

    public static void log(Object message) {
        container.addMessage(new DefaultMessage(MessageType.OBJ_TYPE, String.valueOf(message)));

    }

    public static void log(int... message) {

    }

    public static void log(int[][] message) {

    }

    public static void log(String... message) {

    }

    public static void flush() {
        System.out.print(container.getText());
        container = new MessageContainer();
    }
/*
    private static void stringArrayOut() {
        if (strArrayContainer != null) {
            for (int i = 0; i < strArrayContainer.length; i++) {
                getPrintln(strArrayContainer[i]);
            }
        }
    }

    private static int sumArray() {
        int sum = 0;
        if (intArrayContainer != null) {
            for (int i = 0; i < intArrayContainer.length; i++) sum += intArrayContainer[i];
        }
        return sum;
    }

    private static String arrayPrint() {
        StringBuilder outage = new StringBuilder();
        for (int i = 0; i < intArrayContainer.length; i++) {
            if (i < intArrayContainer.length - 1) outage.append(intArrayContainer[i]).append(", ");
            else outage.append(intArrayContainer[i]);
        }
        return outage.toString();
    }

    private static int array2dsum() {
        for (int[] ints : array2dContainer) {
            for (int j = 0; j < ints.length; j++) {
                array2dsum += ints[j];
            }
        }
        return array2dsum;
    }

    private static void getPrintln(Object message) {
        System.out.println(message);
    }

    private static void typeCheck(String currentType) {
        if (containerType.isEmpty()) {
            containerType = currentType;
        } else if (!containerType.equals(currentType)) {
            Logger.flush();
            containerType = currentType;
        }
    }

    private static void primOps(int number, int full) {
        int prefull = full - intContainer;
        if (number >= prefull) {
            intContainer = full;
            Logger.flush();
            intContainer = number - prefull;
        } else {
            intContainer += number;
        }
    }
*/
}
