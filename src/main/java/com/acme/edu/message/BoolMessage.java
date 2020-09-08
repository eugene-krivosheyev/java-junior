package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Collections;

public class BoolMessage implements AbstractMessage {
    static public String PREFIX = "primitive: ";

    public BoolMessage(boolean message) {
        messageController.setLength(0);
        prepareMessage(new ArrayList<>(Collections.singleton(message)));
    }

    @Override
    public void prepareMessage(ArrayList<Object> listOfLog) {
        messageController
                .append(PREFIX)
                .append(listOfLog.get(0));
    }
}
