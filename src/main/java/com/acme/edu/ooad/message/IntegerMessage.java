package com.acme.edu.ooad.message;

import java.util.ArrayList;

public class IntegerMessage extends ObjectMessage{

    private static int buffer;
    private static int thresholdOverflowCounter;

    private static final int thresholdMinValue = Integer.MIN_VALUE;
    private static final int thresholdMaxValue = Integer.MAX_VALUE;

    private final int value;

    private enum ChangeType {
        INCREASE,
        DECREASE
    }

    protected int getValue() {
        return value;
    }

    public IntegerMessage(int value) {
        super("primitive: ");
        this.value = value;
      //  process();
    }

    @Override
    public String toString() {
        ArrayList<String> strRepresentation = new ArrayList<String>();
        int thresholdValue = thresholdOverflowCounter > 0 ? thresholdMaxValue : thresholdMinValue;
        for (int i = 0; i < Math.abs(thresholdOverflowCounter); i++) {
            strRepresentation.add(prefix+thresholdValue);
        }
        if (thresholdOverflowCounter == 0 || buffer != 0) {
            strRepresentation.add(prefix+buffer);
        }
        return String.join(System.lineSeparator(), strRepresentation);
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

    public void clean() {
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

    private boolean isMessageEqualThresholdValue(int thresholdValue) {
        if (value == thresholdValue) {
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

    private void changeThresholdValueCounter(ChangeType changeType) {
        switch (changeType) {
            case INCREASE: {
                if (thresholdOverflowCounter < 0) {
                    decreaseBuffer();
                }
                ++thresholdOverflowCounter;

                break;
            }
            case DECREASE: {
                if (thresholdOverflowCounter > 0) {
                    decreaseBuffer();
                }
                --thresholdOverflowCounter;

                break;
            }
        }
    }

//    private int getThresholdOverflowCounter() {
//        return thresholdOverflowCounter;
//    }

// process array
//    public void process(int... messages) {
//        for (var message : messages) {
//            process(message);
//        }
//    }

    public void process() {
        int thresholdValue = getThresholdValue(value);
        if (isMessageEqualThresholdValue(thresholdValue)) return;

        int buffer = getBuffer();

        long diff = Math.abs(thresholdValue - (long) buffer);
        if (diff > Math.abs((long) value)) {
            appendBuffer(value);
        } else {
            if (thresholdValue > 0) {
                assignBuffer((int) (value - diff));
                changeThresholdValueCounter(ChangeType.INCREASE);
            } else {
                assignBuffer((int) (value + diff));
                changeThresholdValueCounter(ChangeType.DECREASE);
            }
        }
    }

//    @Override
//    public IntegerMessage flush() {
//        clean();
//        return this;
//    }

}
