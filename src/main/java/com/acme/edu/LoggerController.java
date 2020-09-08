package com.acme.edu;

import com.acme.edu.message.AbstractMessage;
import com.acme.edu.saver.Saver;

import java.util.ArrayList;

/**
 * Controller for logged messages. Collects messages of the
 * same type to listOfLog and then process them in flush function
 * for further output
 *
 */
public class LoggerController {
    private final Saver saver;
    private AbstractMessage currentState = null;
    static ArrayList<AbstractMessage> listOfLog = new ArrayList<>();

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    /**
     * Collects messages if they are of the same type or save them
     *
     * @param message
     */
    public void log(AbstractMessage message) {
        if (listOfLog.size() == 0) {
            currentState = message;
            listOfLog.add(message);
            return;
        }
        if (!currentState.isSameType(message)) {
            flushStart();
        }
        listOfLog.add(message);
        currentState = message;

    }

    /**
     * Prepares list of messages and saves them
     */
    public void flushStart() {
        AbstractMessage firstToLog = listOfLog.get(0);
        firstToLog.prepareMessage(listOfLog);
        listOfLog.clear();
        saver.save(AbstractMessage.messageController.toString());
        AbstractMessage.messageController.setLength(0);
    }
}
