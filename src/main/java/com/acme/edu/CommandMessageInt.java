package com.acme.edu;

import static com.acme.edu.MessageTypeName.INT;
import static java.lang.System.lineSeparator;

public class CommandMessageInt implements CommandMessage {
    private int message;

    public CommandMessageInt(int message) {
        this.message = message;
    }

    @Override
    public MessageTypeName getTypeName() {
        return INT;
    }

    @Override
    public void accumulate(ControllerState state) {
        int accumulatedSum = state.getAccumulatedSum();
        if (message > 0) {
            if (accumulatedSum > Integer.MAX_VALUE - message) {
                state.setAccumulatedString(accumulatedSum + lineSeparator());
                state.setAccumulatedSum(Integer.MAX_VALUE);
            } else {
                state.setAccumulatedSum(state.getAccumulatedSum() + message);
            }
        } else {
            if (accumulatedSum < Integer.MIN_VALUE - message) {
                state.setAccumulatedString(accumulatedSum + lineSeparator());
                state.setAccumulatedSum(Integer.MIN_VALUE);
            } else {
                state.setAccumulatedSum(state.getAccumulatedSum() + message);
            }
        }
    }

    @Override
    public void typeSwitchUpdate(ControllerState state) {
        state.setAccumulatedString(Integer.toString(state.getAccumulatedSum()));
        state.setAccumulatedSum(0);
    }
}
