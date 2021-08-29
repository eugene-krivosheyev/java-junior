package com.db.education.app.message;

public abstract class AbstractSmallNumericOverflowableMessage<T extends AbstractSmallNumericOverflowableMessage<T>> {

    protected boolean overflow(T thisMessage, int min, int max, T received) {
        boolean overflow = false;
        int threshold = 0;
        long thisBody = thisMessage.getBody();

        if (thisBody > max) {
            threshold = max;
            overflow = true;
        } else if (thisBody < min) {
            threshold = min;
            overflow = true;
        }

        if (overflow) {
            handleOverflow(thisMessage, threshold, received);
        }
        return overflow;
    }

    private void handleOverflow(T thisMessage, int threshold, T received) {
        received.setBody(thisMessage.getBody() - threshold);
        this.setBody(threshold);
    }

    abstract void setBody(long body);
    abstract long getBody();
}
