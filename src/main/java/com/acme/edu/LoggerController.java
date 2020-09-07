package com.acme.edu;

import com.acme.edu.data.MessagePrefix;
import com.acme.edu.data.MessageType;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.LoggerMessage;
import com.acme.edu.utils.ConsoleSaver;

public class LoggerController {
    private LoggerMessage currentState = null; // type

    public void postProcessing() {
        this.currentState.printMessageBuffer();
    }

    public void log(LoggerMessage message) {
        if (currentState == null) {
            this.currentState = message;
            currentState.accumulateMessage(message);
            return;
        }
        if (currentState.isSameType(message)) {
            currentState.accumulateMessage(message);
        } else {
            currentState.printMessageBuffer();
            this.currentState = message; // loggerm = intm
            currentState.accumulateMessage(message);
        }
    }

    public void clearLoggerMassageCash() {
        this.currentState = null;
    }
}
