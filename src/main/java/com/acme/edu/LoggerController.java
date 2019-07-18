package com.acme.edu;

public class LoggerController {
    private ControllerState state;

    public LoggerController(ControllerState state) {
        this.state = state;
    }

    public void proceed(CommandMessage commandMessage)
    {
        if (state.getPreviousState() != commandMessage.getTypeName()) {
            commandMessage.typeSwitchUpdate(state);
        }
        commandMessage.accumulate(state);
    }

    public String getAccumulatedString() {
        String tmp = state.getAccumulatedString();
        state = new ControllerState();
        return tmp;
    }
}
