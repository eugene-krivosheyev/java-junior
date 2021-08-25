package com.acme.edu.ooad.message;

import java.util.ArrayList;

public class ByteMessage extends ObjectMessage{

    private static byte buffer;
    private static int thresholdOverflowCounter;

    private static final byte thresholdMinValue = Byte.MIN_VALUE;
    private static final byte thresholdMaxValue = Byte.MAX_VALUE;

    private final byte value;

    private enum ChangeType {
        INCREASE,
        DECREASE
    }

    protected int getValue() {
        return value;
    }

    public ByteMessage(byte value) {
        super("primitive: ");
        this.value = value;

//        process();
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


    private void assignBuffer(byte newBuffer) {
        buffer = newBuffer;
    }

    private void appendBuffer(byte value) {
        buffer += value;
    }

    private byte getBuffer() {
        return buffer;
    }

    public void clean() {
        buffer = 0;
        thresholdOverflowCounter = 0;
    }

    byte getThresholdValue(byte message) {
        if (message > 0) {
            return thresholdMaxValue;
        } else {
            return thresholdMinValue;
        }
    }

    private boolean isMessageEqualThresholdValue(byte thresholdValue) {
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
//    public void process(byte... messages) {
//        for (var message : messages) {
//            process(message);
//        }
//    }

    public void process() {
        byte thresholdValue = getThresholdValue(value);
        if (isMessageEqualThresholdValue(thresholdValue)) return;

      //  int buffer = getBuffer();

        long diff = Math.abs(thresholdValue - (long) buffer);
        if (diff > Math.abs((long) value)) {
            appendBuffer(value);
        } else {
            if (thresholdValue > 0) {
                assignBuffer((byte) (value - diff));
                changeThresholdValueCounter(ChangeType.INCREASE);
            } else {
                assignBuffer((byte) (value + diff));
                changeThresholdValueCounter(ChangeType.DECREASE);
            }
        }
    }

//    @Override
//    public ByteMessage flush() {
//        clean();
//        return this;
//    }

}
