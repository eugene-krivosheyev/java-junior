package com.acme.edu.message;

import java.util.ArrayList;
import java.util.Collections;

public class BoolMessage extends AbstractMessage {

    public BoolMessage(boolean message) {
        PREFIX = "primitive: ";
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
