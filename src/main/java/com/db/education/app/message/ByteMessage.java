package com.db.education.app.message;

public class ByteMessage extends AbstractSmallNumericOverflowableMessage implements Message {

    private static final Byte MAX = Byte.MAX_VALUE;
    private static final Byte MIN = Byte.MIN_VALUE;
    private final String TYPE = "BYTE";

    private long body;
    private boolean needsFlush = false;

    public ByteMessage(byte body) {
        this.body = body;
    }

    /**
     * Accumulates Bytes and prevents overflow
     * */
    @Override
    public ByteMessage accumulate(Message message) {
        if (!typeEquals(message)) {
            this.needsFlush = true;
            return this;
        }

        ByteMessage received = (ByteMessage) message;
        this.body += received.body;

        if (super.overflow(this, MIN, MAX, received)) {
            this.needsFlush = true;
        }
        return this;
    }

    @Override
    public boolean needsFlush() {
        return this.needsFlush;
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
