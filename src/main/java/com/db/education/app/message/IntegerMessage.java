package com.db.education.app.message;

public class IntegerMessage extends AbstractSmallNumericOverflowableMessage<IntegerMessage> implements Message {

    private static final Integer MAX = Integer.MAX_VALUE;
    private static final Integer MIN = Integer.MIN_VALUE;
    private final String TYPE = "INT";

    private long body;
    private boolean needsFlush = false;

    public IntegerMessage(int body) {
        this.body = body;
    }

    /**
     * Accumulates Integers and prevents overflow
     * */
    @Override
    public IntegerMessage accumulate(Message message) {
        if (!typeEquals(message)) {
            this.needsFlush = true;
            return this;
        }

        IntegerMessage received = (IntegerMessage) message;
        this.body += received.body;

        if (super.overflow(this, MIN, MAX, received)) {
            this.needsFlush = true;
        }
        return this;
    }

    @Override
    public boolean needsFlush() {
        return needsFlush;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    @Override
    public String toString() {
        return "primitive: " + body + System.lineSeparator();
    }

    @Override
    void setBody(long body) {
        this.body = body;
    }

    @Override
    long getBody() {
        return this.body;
    }
}
