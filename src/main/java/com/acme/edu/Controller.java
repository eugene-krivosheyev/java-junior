package com.acme.edu;


import com.acme.edu.messages.Message;

public class Controller {
    private Message currentState;
    private boolean start = true;
    private Printer printer;

    public Controller(Printer printer){
        this.printer = printer;
    }

    public void log(Message message) {
        if (start) {
            currentState = message;
            currentState.init();
            start = false;
        } else {
            if (!currentState.isSameType(message)) {
                flush();
                currentState = message;
                currentState.init();
            } else {
                currentState = currentState.accumulate(message);
            }
        }
    }

    public void flush() {
        printer.print(currentState.flush());
    }
}
