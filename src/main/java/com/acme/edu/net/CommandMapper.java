package com.acme.edu.net;

import com.acme.edu.Logger;

import java.util.Arrays;
import java.util.function.Function;

public class CommandMapper {
    private String createMessageFromArray(String[] array) {
        StringBuilder message = new StringBuilder();
        for (int currentIndex = 0; currentIndex < array.length; ++currentIndex) {
            if (currentIndex == array.length - 1) {
                message.append(array[currentIndex]);
            } else {
                message.append(array[currentIndex]).append(" ");
            }
        }
        return message.toString();
    }

    private int executeInteger(String[] splittedCommand, Function<String[], Integer> valueOf) {
        int messageArgument = valueOf.apply(splittedCommand);
        return Logger.log(messageArgument);
    }

    private int executeString(String[] splittedCommand, Function<String[], String> valueOf) {
        String messageArgument = valueOf.apply(splittedCommand);
        return Logger.log(messageArgument);
    }

    private int executeChar(String[] splittedCommand, Function<String[], Character> valueOf) {
        char messageArgument = valueOf.apply(splittedCommand);
        return Logger.log(messageArgument);
    }

    private int executeObject(String[] splittedCommand, Function<String[], Object> valueOf) {
        Object messageArgument = valueOf.apply(splittedCommand);
        return Logger.log(messageArgument);
    }

    private int executeBoolean(String[] splittedCommand, Function<String[], Boolean> valueOf) {
        boolean messageArgument = valueOf.apply(splittedCommand);
        return Logger.log(messageArgument);
    }

    private int executeIntArray(String[] splittedCommand, Function<String[], int[]> valueOf) {
        int[] messageArgument = valueOf.apply(splittedCommand);
        return Logger.log(messageArgument);
    }

    public int mapAndExecute(String command) {
        String[] splittedCommand = command.split("\\s");
        if (splittedCommand.length > 2) {
            if ("log".equals(splittedCommand[0])) {
                if ("int".equals(splittedCommand[1])) {
                    return executeInteger(splittedCommand, (commandArray) -> Integer.parseInt(createMessageFromArray(
                            Arrays.copyOfRange(commandArray, 2, commandArray.length))));
                }

                if ("char".equals(splittedCommand[1])) {
                    return executeChar(splittedCommand, (commandArray) -> createMessageFromArray(
                            Arrays.copyOfRange(commandArray, 2, commandArray.length)).charAt(0));
                }

                if ("string".equals(splittedCommand[1])) {
                    return executeString(splittedCommand, (commandArray) -> (createMessageFromArray(
                            Arrays.copyOfRange(commandArray, 2, commandArray.length))));
                }

                if ("object".equals(splittedCommand[1])) {
                    return executeObject(splittedCommand, (commandArray) -> (createMessageFromArray(
                            Arrays.copyOfRange(commandArray, 2, commandArray.length))));
                }

                if ("boolean".equals(splittedCommand[1])) {
                    return executeBoolean(splittedCommand, (commandArray) -> Boolean.getBoolean(createMessageFromArray(
                            Arrays.copyOfRange(commandArray, 2, commandArray.length))));
                }
            }
        }
        return -1;
    }
}
