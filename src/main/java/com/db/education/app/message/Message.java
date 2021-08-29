package com.db.education.app.message;

import java.util.Objects;

public interface Message {

    /**
     * @param message message to be accumulated with
     * @return accumulated or current message if shouldn't be accumulated
     */
    Message accumulate(Message message);

    String getType();

    default boolean typeEquals(Message otherMessage) {
        return Objects.equals(this.getType(), otherMessage.getType());
    }

    default boolean isEmptyMessage() {
        return false;
    };

    default boolean needsFlush() {
        return true;
    }
}
