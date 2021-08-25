package com.db.edu;

public class LoggerController {

    static State state = State.NULL;
    static IntMessage intState;
    static StringMessage stringState;

    public static void close() {
        IntMessage.printAccumulatedInt();
        StringMessage.printAccumulatedString();
    }

    public void log(IntMessage message) {
        if (state.equals(State.STRINGS)){
            StringMessage.printAccumulatedString();
        }
        IntMessage.accumulate(message);
        state = State.INTS;
    }

    public void log(StringMessage message) {
        if (state.equals(State.INTS)){
            IntMessage.printAccumulatedInt();
        }
        StringMessage.accumulate(message);
        state = State.STRINGS;
    }

}
