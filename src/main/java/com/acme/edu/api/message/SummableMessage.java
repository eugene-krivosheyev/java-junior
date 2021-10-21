package com.acme.edu.api.message;

public abstract class SummableMessage extends Message {
    private String overflows = "";
    private long currentSum = 0;
    private long max;
    private long min;

    @Override
    public String getMessageAsString() {
        return overflows + super.getMessageAsString();
    }

    @Override
    public Message accumulate(Message message) {
        SummableMessage newMessage = (SummableMessage) message;
        SummableMessage result = getNewMessageOfMyType(handleOverflows(newMessage.getCurrentSum()));
        result.setOverflows(overflows);
        return result;
    }

    protected abstract SummableMessage getNewMessageOfMyType(long value);

    protected void setOverflows(String overflows) {
        this.overflows = overflows;
    }

    protected long getCurrentSum() {
        return currentSum;
    }

    protected void setCurrentSum(long sum) {
        currentSum = sum;
    }

    protected long handleOverflows(long add) {
        long result = currentSum + add;
        if (result > Integer.MAX_VALUE) {
            setOverflows(Integer.MAX_VALUE + System.lineSeparator());
            result -= Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            setOverflows(Integer.MIN_VALUE + System.lineSeparator());
            result -= Integer.MIN_VALUE;
        }
        return result;
    }
}
