package com.acme.edu.ooad.message;

import java.util.Objects;

public interface Message {
    void clean();
    String toString();
    static boolean sameType(Message message1, Message message2) {
        if (message1 == null || message2 == null) return false;
        return Objects.equals(message1.getClass(),message2.getClass());
    }
    Message getNewInstance(Message message);
    Message getInstanceToPrint(Message message);
}
