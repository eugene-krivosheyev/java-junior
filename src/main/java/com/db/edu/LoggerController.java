package com.db.edu;

public class LoggerController {

    State state = State.NULL;
    IntMessage intState = new IntMessage(0);
    StringMessage stringState = new StringMessage("");
    Message lastMessage;

    public void close() {
        if (state != State.NULL) {
            lastMessage.printAccumulated();
            state = State.NULL;
        }
        //intState.printAccumulatedInt();
        //stringState.printAccumulatedString();
    }

    public void log(Message message) {
        if (state == State.NULL) {
            lastMessage = message;
            state = State.NOT_NULL;
        } else if (message.typeEquals(lastMessage)) {
            lastMessage.accumulate(message);
        } else {
            lastMessage.printAccumulated();
            lastMessage = message;
        }
    }
    /*
    public void log(IntMessage message) {
        if (!state.equals(State.INTS)) {
            stringState.printAccumulatedString();
        }
        intState.accumulate(message);
        state = State.INTS;
    }

    public void log(StringMessage message) {
        if (!state.equals(State.STRINGS)) {
            intState.printAccumulatedInt();
        }
        stringState.accumulate(message);
        state = State.STRINGS;
    }

    public void log(ByteMessage message) {
        if (!state.equals(State.NULL)) {
            intState.printAccumulatedInt();
            stringState.printAccumulatedString();
        }
        message.printAccumulatedBytes();
        state = State.NULL;
    }

    public void log(CharMessage message) {
        if (!state.equals(State.NULL)) {
            intState.printAccumulatedInt();
            stringState.printAccumulatedString();
        }
        message.printAccumulatedChar();
        state = State.NULL;
    }

    public void log(BoolMessage message) {
        if (!state.equals(State.NULL)) {
            intState.printAccumulatedInt();
            stringState.printAccumulatedString();
        }
        message.printAccumulatedBool();
        state = State.NULL;
    }

    public void log(ObjectMessage message) {
        if (!state.equals(State.NULL)) {
            intState.printAccumulatedInt();
            stringState.printAccumulatedString();
        }
        message.printAccumulatedObject();
        state = State.NULL;
    }
        */
}
