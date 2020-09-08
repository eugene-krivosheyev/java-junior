package com.acme.edu;

import com.acme.edu.message.AbstractMessage;
import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.Saver;

import java.util.ArrayList;

public class LoggerController {
    private final Saver saver;
    static ArrayList<Object> listOfLog = new ArrayList<>();

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void log(AbstractMessage message) {
        listOfLog.add(message);
    }

    public void addToLogList(Object message) {
        listOfLog.add(message);
    }

    public void flushStart() {
        Object firstToLog = listOfLog.get(0);

        if (firstToLog instanceof Integer) {
            this.saver.save(new IntMessage(listOfLog));
        } else if (firstToLog instanceof Byte) {
            this.saver.save(new ByteMessage(listOfLog));
        } else if (firstToLog instanceof String) {
            this.saver.save(new StringMessage(listOfLog));
        } else {
            for (Object logMessage : listOfLog) {
                this.saver.save((AbstractMessage) logMessage);
            }
        }
        listOfLog.clear();
    }
}
