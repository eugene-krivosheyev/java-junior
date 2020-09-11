package com.acme.edu;

import com.acme.edu.exception.FlushLogException;
import com.acme.edu.exception.LoggerException;
import com.acme.edu.exception.SaveException;
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
    ArrayList<AbstractMessage> messageQueue = new ArrayList<>();

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    /**
     * Collects messages if they are of the same type or save them
     * @param message AbstractMessage to be logged
     */
    public void log(AbstractMessage message) throws LoggerException {
        if (!messageQueue.isEmpty() && !currentState.isSameType(message)) {
            flush();
        }
        messageQueue.add(message);
        currentState = message;
    }

    /**
     * Prepares list of messages and saves them
     */
    public void flush() throws LoggerException {
        try {
            AbstractMessage firstToLog = messageQueue.get(0);
            firstToLog.prepareMessage(messageQueue);
            saver.save(firstToLog);
        } catch (IndexOutOfBoundsException e) {
            throw new FlushLogException("Message log is empty! See: ", e);
        } catch (Exception e) {
            throw new SaveException("Message cannot be saved correctly", e);
        } finally {
            messageQueue.clear();
        }
    }
}
