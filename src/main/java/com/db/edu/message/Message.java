package com.db.edu.message;

import com.db.edu.State;

public interface Message {

    String decorated();

    boolean isNotEmpty();

    String getValue();

    void flush();

    boolean accumulate(Message message);

    boolean isStateEquals(State state);

    State getState();
}
