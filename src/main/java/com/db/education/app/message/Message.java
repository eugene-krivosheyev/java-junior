package com.db.education.app.message;

public interface Message {
    /**
     * @param message message to be accumulated with
     * @return false for messages that shouldn't be accumulated, true otherwise
     */
    boolean accumulate(Message message);

    boolean typeEquals(Message otherMessage);

    Object getValue();

    String getType();

    default boolean isEmpty() {
        return false;
    };
}
