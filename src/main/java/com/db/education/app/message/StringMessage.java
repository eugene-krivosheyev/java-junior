package com.db.education.app.message;

import java.util.Objects;

public class StringMessage implements Message{

    private final String TYPE = "STRING";

    private String body;
    private int count;
    private boolean needsFlush = false;

    public StringMessage(String body) {
        this.body = body;
        count = 1;
    }

    /**
     * Counts equal strings
     * */
    @Override
    public StringMessage accumulate(Message message) {
        if (!typeEquals(message)) {
            this.needsFlush = true;
            return this;
        }

        if (Objects.equals(body, ((StringMessage) message).body)) {
            ++count;
            this.needsFlush = false;
        } else {
            this.needsFlush = true;
        }
        return this;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    @Override
    public boolean needsFlush() {
        return needsFlush;
    }

    @Override
    public String toString() {
        String countString = (count > 1) ? " (x" + count + ")" : "";
        return "string: " + body + countString + System.lineSeparator();
    }
}
