package com.acme.edu;

public class LoggerController {
    private ControllerState state;
    private CommandMessage previousMessage = null;

    public boolean getLogCount() {
        boolean tmp = logCount < 2;
        logCount = 0;
        return tmp;
    }

    private int logCount = 0;

    public LoggerController(ControllerState state) {
        this.state = state;
    }

    public void proceed(CommandMessage commandMessage) {
        logCount++;
        if (previousMessage != null) {
            if (previousMessage.getTypeName() != commandMessage.getTypeName()) {
                previousMessage.typeSwitchUpdate(state);
            }
        }
        previousMessage = commandMessage;
        commandMessage.accumulate(state);
    }

    public void finishString() {
        previousMessage.typeSwitchUpdate(state);
    }

    public String getAccumulatedString() {
        String tmp = state.getAccumulatedString();
        state = new ControllerState();
        logCount = 0;
        return tmp;
    }

    public String decorator(String message, boolean isPrimitive) {
        if (!isPrimitive) return message;
        return previousMessage.getTypeName().decoratePrimitive(message);
    }
}
