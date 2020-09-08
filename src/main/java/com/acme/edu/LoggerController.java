package com.acme.edu;

import com.acme.edu.message.LoggerMessage;
import com.acme.edu.saver.Saver;

public class LoggerController {
    private LoggerMessage currentAccumulatedMessage = null; // type

    private Saver saver;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    /**
     * Save decorated message, which is accumulated until this moment
     *
     * @see LoggerMessage
     */
    public void postProcessing() {
        this.currentAccumulatedMessage.printMessageBuffer(saver);
    }

    /**
     * Check the type of input message
     * If the type is the same as the type of previous message -> accumulate massage
     * Else save the decorated accumulated message
     *
     * @param message
     */
    public void log(LoggerMessage message) {
        if (currentAccumulatedMessage == null) {
            updateCurrentAccumulatedMessage(message);
            return;
        }
        if (currentAccumulatedMessage.isSameType(message)) {
            currentAccumulatedMessage.accumulateMessage(message);
        } else {
            currentAccumulatedMessage.printMessageBuffer(saver);
            updateCurrentAccumulatedMessage(message);
        }
    }

    private void updateCurrentAccumulatedMessage(LoggerMessage message) {
        this.currentAccumulatedMessage = message;
        currentAccumulatedMessage.accumulateMessage(message);
    }

    /**
     * Flush the content of the currentState message
     */
    public void clearLoggerMassageCache() {
        this.currentAccumulatedMessage = null;
    }
}
