package com.acme.edu.ooad.message;

import java.util.Objects;

public interface Message {
    static boolean sameType(Message message1, Message message2) {
        if (message1 == null || message2 == null) return false;
        return Objects.equals(message1.getClass(), message2.getClass());
    }

    void clean();

    String toString();

    Message getNewInstance(Message message);

    Message getInstanceToPrint(Message message);

    String getBody();
}
