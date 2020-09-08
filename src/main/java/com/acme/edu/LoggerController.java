package com.acme.edu;

import com.acme.edu.message.AbstractMessage;
import com.acme.edu.saver.Saver;

import java.util.ArrayList;

public class LoggerController {
    private final Saver saver;
    private AbstractMessage currentState = null;
    static ArrayList<AbstractMessage> listOfLog = new ArrayList<>();

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void log(AbstractMessage message) {
        if (currentState == null) {
            currentState = message;
            return;
        }

        if (currentState.isSameType(message)) {
            listOfLog.add(message);
        } else {
            flushStart();
            listOfLog.clear();
        }
        currentState = message;
    }

    public void flushStart() {
        AbstractMessage firstToLog = listOfLog.get(0);

        if (listOfLog.size() == 1) {
            this.saver.save(firstToLog);
        } else {
            firstToLog.prepareMessage(listOfLog);
        }
    }
}
