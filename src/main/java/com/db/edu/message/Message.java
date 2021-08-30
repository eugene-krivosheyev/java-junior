package com.db.edu.message;

import com.db.edu.State;

public interface Message {

    String decorated();

    boolean isNotEmpty();

    String getValue();

    void flush();

    Message accumulate(Message message);

    boolean isStateEquals(Message message);

    boolean isStateNotEquals(Message message);

    State getState();
}
