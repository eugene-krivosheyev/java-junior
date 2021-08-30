package com.db.education.app.message;

public abstract class AbstractSmallNumericOverflowableMessage {

    protected boolean overflow(AbstractSmallNumericOverflowableMessage thisMessage, int min, int max,
                               AbstractSmallNumericOverflowableMessage received) {
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

    private void handleOverflow(AbstractSmallNumericOverflowableMessage thisMessage, int threshold,
                                AbstractSmallNumericOverflowableMessage received) {
        received.setBody(thisMessage.getBody() - threshold);
        this.setBody(threshold);
    }

    abstract void setBody(long body);
    abstract long getBody();
}
