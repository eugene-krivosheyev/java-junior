package com.acme.edu.processors;

import com.acme.edu.Flusher;
import com.acme.edu.Stater;
import com.acme.edu.messageOut.Formatter;
import com.acme.edu.messageOut.Printer;

import java.util.Objects;

public class ServiceForString {
    private Formatter formatter;
    private Printer printer;
    private Stater state;
    private Flusher flusher;


    public ServiceForString(Formatter formatter, Printer printer, Stater state, Flusher flusher) {
        this.formatter = formatter;
        this.printer = printer;
        this.state = state;
        this.flusher = flusher;
    }

    public void serviceForString(String message) {
        if (state.getType() != state.getPreviousType()) {
            flusher.flush();
        } else {
            if (Objects.equals(message, state.getBufferString())) {
                state.setStringCounter(state.getStringCounter() + 1);
            } else {
                flusher.flush();
                state.setStringCounter(1);
            }
        }
        formatter.setMessagePrefix("string: ");
        state.setPreviousType(state.getType());
        state.setBufferSum(0);
        state.setBufferString(message);
    }

}
