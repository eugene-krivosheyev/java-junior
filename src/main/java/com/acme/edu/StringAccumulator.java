package com.acme.edu;

/**
 * Created by kate-c on 23/08/2019.
 */
public class StringAccumulator implements Accumulator {

    String message;
    private String stringBuffer = null;
    private int stringCounter = 0;


    @Override
    public void add(Command command) {

    }


    private void initializeStringBuffer(String message) {
        stringBuffer = message;
        stringCounter = 1;
    }

    private void flush() {
        if (stringBuffer == null) return;
        String message = stringBuffer;
        if (stringCounter > 1) {
            message += " (x" + stringCounter + ")";
        }
        accomulatedMessage = message;
        stringBuffer = null;
    }


    @Override
    public void accumulate() {
        if (stringBuffer == null) {
            initializeStringBuffer(message);
        } else if (stringBuffer.equals(message)) {
            stringCounter++;
        } else {
            flush();
            initializeStringBuffer(message);
        }
    }
}
