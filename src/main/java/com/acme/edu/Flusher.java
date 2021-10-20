package com.acme.edu;

import com.acme.edu.messageOut.Formatter;
import com.acme.edu.messageOut.Printer;

public class Flusher {

    private Formatter formatter;
    private Printer printer;
    private Stater state;

    public Flusher(Formatter formatter, Printer printer, Stater state) {
        this.formatter = formatter;
        this.printer = printer;
        this.state = state;
    }

    public void flush() {
        if (state.getPreviousType() != Stater.TypeVar.DEFAULT_STATE && (state.getPreviousType() == Stater.TypeVar.INT_STATE || state.getPreviousType() == Stater.TypeVar.BYTE_STATE)) {
            printer.print(formatter.formatMessage(state.getBufferSum()));
        } else if (state.getPreviousType() != Stater.TypeVar.DEFAULT_STATE && state.getPreviousType() == Stater.TypeVar.STRING_STATE) {
            flushForOneString();
        }
        state.setBufferSum(0);
        state.setStringCounter(1);
    }

    private void flushForOneString() {
        if (state.getStringCounter() == 1) {
            printer.print(formatter.formatMessage(state.getBufferString()));
        } else {
            printer.print(formatter.formatMessage(state.getBufferString() + " (x" + state.getStringCounter() + ")"));
        }
    }

}
