package com.acme.edu.message;

import java.util.ArrayList;

import static java.lang.System.lineSeparator;

public class IntMessage implements AbstractMessage {
    static public String PREFIX = "primitive: ";

    public IntMessage(ArrayList<Object> listOfLog) {
        messageController.setLength(0);
        prepareMessage(listOfLog);
    }

    @Override
    public void prepareMessage(ArrayList<Object> listOfLog) {
        int resultIntSum = 0;
        for (Object currentValue : listOfLog) {
            if (Integer.MAX_VALUE - resultIntSum < (int) currentValue) {
                resultIntSum = (int) currentValue - (Integer.MAX_VALUE - resultIntSum);
                messageController
                        .append(PREFIX)
                        .append(Integer.MAX_VALUE)
                        .append(lineSeparator());
            } else {
                resultIntSum += (int) currentValue;
            }
        }
        messageController.append(PREFIX).append(resultIntSum);
    }
}
