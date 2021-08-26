package com.acme.edu.ooad.message;

public class NumericMessage extends AccumulatedMessage {

    private final int value;

    private static int buffer;
    private static int thresholdOverflowCounter;

    public NumericMessage(int value) {
        super("primitive: ");
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        int optionalMessageCounter = (buffer != 0 || thresholdOverflowCounter == 0) ? 1 : 0;
        int counter = Math.abs(thresholdOverflowCounter);

        int overflowValue = getThresholdValue(thresholdOverflowCounter);
        for (int i = 0; i < counter - 1; ++i) {
            res.append(getPrefix()).append(overflowValue).append(System.lineSeparator());
        }

        if (counter > 0) {
            res.append(getPrefix()).append(overflowValue);
            if (optionalMessageCounter == 1) {
                res.append(System.lineSeparator());
            }
        }

        if (optionalMessageCounter == 1) {
            res.append(getPrefix()).append(buffer);
        }

        return res.toString();
    }

    enum ChangeType {
        INCREASE,
        DECREASE
    }

    protected int getThresholdMinValue() {
        return 0;
    }

    protected int getThresholdMaxValue() {
        return 0;
    }

    private static void assignBuffer(int newBuffer) {
        buffer = newBuffer;
    }

    private static void appendBuffer(int value) {
        buffer += value;
    }

    private static int getBuffer() {
        return buffer;
    }

    public void clean() {
        buffer = 0;
        thresholdOverflowCounter = 0;
    }

    private int getThresholdValue(int message) {
        if (message > 0) {
            return getThresholdMaxValue();
        } else {
            return getThresholdMinValue();
        }
    }

    private boolean isMessageEqualThresholdValue(int message, int thresholdValue) {
        if (message == thresholdValue) {
            if (thresholdValue > 0) {
                changeThresholdValueCounter(NumericMessage.ChangeType.INCREASE);
            } else {
                changeThresholdValueCounter(NumericMessage.ChangeType.DECREASE);
            }
            return true;
        } else {
            return false;
        }
    }

    private void decreaseBuffer() {
        --buffer;
        if (buffer == getThresholdMinValue()) {
            buffer = 0;
            --thresholdOverflowCounter;
        }
    }

    private void changeThresholdValueCounter(NumericMessage.ChangeType changeType) {
        switch (changeType) {
            case INCREASE: {
                if (getThresholdOverflowCounter() < 0) {
                    decreaseBuffer();
                }
                ++thresholdOverflowCounter;

                break;
            }
            case DECREASE: {
                if (getThresholdOverflowCounter() > 0) {
                    decreaseBuffer();
                }
                --thresholdOverflowCounter;

                break;
            }
        }
    }

    private static int getThresholdOverflowCounter() {
        return thresholdOverflowCounter;
    }

    public void process() {
        int thresholdValue = getThresholdValue(value);
        if (isMessageEqualThresholdValue(value, thresholdValue)) return;

        int buffer = getBuffer();

        long diff = Math.abs(thresholdValue - (long) buffer);
        if (diff > Math.abs((long) value)) {
            appendBuffer(value);
        } else {
            if (thresholdValue > 0) {
                assignBuffer((int) (value - diff));
                changeThresholdValueCounter(NumericMessage.ChangeType.INCREASE);
            } else {
                assignBuffer((int) (value + diff));
                changeThresholdValueCounter(NumericMessage.ChangeType.DECREASE);
            }
        }
    }
}
