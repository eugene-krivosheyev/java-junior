package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayMessage implements AbstractMessage {
    static public String PREFIX = "primitives array: ";

    public ArrayMessage(int[] message) {
        messageController.setLength(0);
        prepareMessage(new ArrayList<>(Collections.singleton(message)));
    }

    @Override
    public void prepareMessage(ArrayList<Object> listOfLog) {
        String preparedMessage = Arrays.toString((int[]) listOfLog.get(0));
        messageController.append(PREFIX).append(preparedMessage);
    }
}
