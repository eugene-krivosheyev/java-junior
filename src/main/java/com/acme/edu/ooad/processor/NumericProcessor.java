package com.acme.edu.ooad.processor;

import com.acme.edu.ooad.message.NumericMessage;
import com.acme.edu.ooad.message.ObjectMessage;

public class NumericProcessor extends Processor {

    enum ChangeType {
        INCREASE,
        DECREASE
    }

    private int buffer;
    private int thresholdOverflowCounter;

    private final int thresholdMinValue;
    private final int thresholdMaxValue;

    public NumericProcessor(int thresholdMinValue, int thresholdMaxValue) {
        this.thresholdMinValue = thresholdMinValue;
        this.thresholdMaxValue = thresholdMaxValue;
    }

    private void assignBuffer(int newBuffer) {
        buffer = newBuffer;
    }

    private void appendBuffer(int value) {
        buffer += value;
    }

    private int getBuffer() {
        return buffer;
    }

    private void cleanBuffer() {
        buffer = 0;
        thresholdOverflowCounter = 0;
    }

    int getThresholdValue(int message) {
        if (message > 0) {
            return thresholdMaxValue;
        } else {
            return thresholdMinValue;
        }
    }

    private boolean isMessageEqualThresholdValue(int message, int thresholdValue) {
        if (message == thresholdValue) {
            if (thresholdValue > 0) {
                changeThresholdValueCounter(ChangeType.INCREASE);
            } else {
                changeThresholdValueCounter(ChangeType.DECREASE);
            }
            return true;
        } else {
            return false;
        }
    }

    private void decreaseBuffer() {
        --buffer;
        if (buffer == thresholdMinValue) {
            buffer = 0;
            --thresholdOverflowCounter;
        }
    }

    private void changeThresholdValueCounter(NumericProcessor.ChangeType changeType) {
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

    private int getThresholdOverflowCounter() {
        return thresholdOverflowCounter;
    }

    public void process(int... messages) {
        for (var message : messages) {
            process(message);
        }
    }

    public void process(int message) {
        int thresholdValue = getThresholdValue(message);
        if (isMessageEqualThresholdValue(message, thresholdValue)) return;

        int buffer = getBuffer();

        long diff = Math.abs(thresholdValue - (long) buffer);
        if (diff > Math.abs((long) message)) {
            appendBuffer(message);
        } else {
            if (thresholdValue > 0) {
                assignBuffer((int) (message - diff));
                changeThresholdValueCounter(ChangeType.INCREASE);
            } else {
                assignBuffer((int) (message + diff));
                changeThresholdValueCounter(ChangeType.DECREASE);
            }
        }
    }

    @Override
    public ObjectMessage[] flush() {
        int optionalMessageCounter = (buffer != 0 || thresholdOverflowCounter == 0) ? 1 : 0;
        int counter = Math.abs(thresholdOverflowCounter);

        NumericMessage[] res = new NumericMessage[counter + optionalMessageCounter];

        int overflowValue = getThresholdValue(thresholdOverflowCounter);
        for (int i = 0; i < counter; ++i) {
            res[i] = new NumericMessage(overflowValue);
        }

        if (optionalMessageCounter == 1) {
            res[counter] = new NumericMessage(buffer);
        }

        cleanBuffer();
        return res;
    }
}
