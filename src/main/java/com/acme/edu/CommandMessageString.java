package com.acme.edu;

import static com.acme.edu.MessageTypeName.STRING;

public class CommandMessageString implements CommandMessage {
    private String message;

    public CommandMessageString(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public MessageTypeName getTypeName() {
        return STRING;
    }

    @Override
    public void accumulate(ControllerState state) {
        if (state.getPreviousState() == STRING) {
            stringChanger(state);
        }
        state.setPreviousString(message);
    }

    @Override
    public void typeSwitchUpdate(ControllerState state) {
        if (!state.getPreviousString().equals("")) {
            state.setAccumulatedString(state.getPreviousString() + (state.getStringCounter() <= 1 ? "" : " (x" + state.getStringCounter() + ")"));
        }
        state.setPreviousString("");
    }

    public void stringChanger(ControllerState state) {
        if (state.getPreviousString().equals(message)) {
            state.setStringCounter(state.getStringCounter() + 1);
            return;
        }
        if (!state.getPreviousString().equals("")) {
            state.setAccumulatedString(state.getPreviousString() + (state.getStringCounter() <= 1 ? "" : " (x" + state.getStringCounter() + ")"));
        }
        state.setPreviousString(message);
    }
}
