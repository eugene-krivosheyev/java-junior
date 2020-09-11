package com.acme.edu;

import com.acme.edu.exception.LoggerControllerException;
import com.acme.edu.message.AbstractMessage;
import com.acme.edu.saver.Saver;

import java.util.ArrayList;

/**
 * Controller for logged messages. Collects messages of the
 * same type to listOfLog and then process them in flush function
 * for further output
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
     * @param message AbstractMessage to be logged
     */
    public void log(AbstractMessage message) throws LoggerControllerException {
        if (listOfLog.size() != 0 && !currentState.isSameType(message)) {
            flushStart();
        }
        listOfLog.add(message);
        currentState = message;
    }

    /**
     * Prepares list of messages and saves them
     */
    public void flushStart() throws LoggerControllerException {
        try {
            AbstractMessage firstToLog = listOfLog.get(0);
            firstToLog.prepareMessage(listOfLog);
            saver.save(firstToLog);
        } catch (IndexOutOfBoundsException e){
            throw new LoggerControllerException("ListOfLog is empty");
        }
        listOfLog.clear();
    }
}
