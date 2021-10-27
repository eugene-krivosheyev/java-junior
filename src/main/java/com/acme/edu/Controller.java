package com.acme.edu;


import com.acme.edu.messages.Message;

public class Controller {
    private Message currentState;
    private boolean start = true;
    private Printer printer;

    public Controller(Printer printer) {
        this.printer = printer;
    }

    public void log(Message message) {
        if (message == null) throw new IllegalArgumentException("null message");
        if (start) {
            currentState = message;
            start = false;
        } else {
            if (!currentState.isSameType(message)) {
                flush(message);
            } else {
                currentState = currentState.accumulate(message);
            }
        }
    }

    public void flush(Message message) {
        try {
            printer.print(currentState.flush());
            currentState = message;
        } catch (IllegalStringToPrintExeption e) {
            throw new LogException("Can't print message!",e);
        }
    }

    public void flush() {
        try {
            printer.print(currentState.flush());
            start = true;
        } catch (IllegalStringToPrintExeption e) {
            throw new LogException("Can't print message!",e);
        }
    }

  }