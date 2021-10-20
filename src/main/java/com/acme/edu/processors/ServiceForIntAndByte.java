package com.acme.edu.processors;

import com.acme.edu.Flusher;
import com.acme.edu.Stater;
import com.acme.edu.messageOut.Formatter;
import com.acme.edu.messageOut.Printer;

public class ServiceForIntAndByte {
    private Formatter formatter;
    private Printer printer;
    private Stater state;
    private Flusher flusher;


    public ServiceForIntAndByte(Formatter formatter, Printer printer, Stater state, Flusher flusher) {
        this.formatter = formatter;
        this.printer = printer;
        this.state = state;
        this.flusher = flusher;
    }

    public void processingForIntAndByte(int message) {
        formatter.setMessagePrefix("primitive: ");
        int maxValue = (state.getType() == Stater.TypeVar.INT_STATE) ? Integer.MAX_VALUE : Byte.MAX_VALUE;
        if (state.getType() != state.getPreviousType()) {
            flusher.flush();
            state.setPreviousType(state.getType());
            state.setBufferSum(state.getBufferSum() + message);
        } else {
            processingForBigValue(message, maxValue);
        }
    }

    private void processingForBigValue(int message, int maxValue) {
        if ((Long.valueOf(state.getBufferSum()) + Long.valueOf(message)) < maxValue) {
            state.setBufferSum(state.getBufferSum() + message);
        } else {
            printer.print(formatter.formatMessage(maxValue));
            state.setBufferSum(message - (maxValue - state.getBufferSum()));
        }
    }
}
