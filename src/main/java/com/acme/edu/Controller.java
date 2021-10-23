package com.acme.edu;


import com.acme.edu.messages.Message;

public class Controller {
    private static Message currentState;
    private static boolean start = true;

    public static void log(Message message) {
        if (start) {
            currentState = message;
            currentState.init();
            start = false;
        } else {
            if (!currentState.isSameType(message)) {
                currentState.flush();
                currentState = message;
                currentState.init();
            } else {
                currentState = currentState.accumulate(message);
            }
        }
    }

    public static void flush() {
        currentState.flush();
    }
}
