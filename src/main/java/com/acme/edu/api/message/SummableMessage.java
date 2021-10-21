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

    protected void setMax(long max) {
        this.max = max;
    }

    protected void setMin(long min) {
        this.min = min;
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
        if (result > max) {
            setOverflows(max + System.lineSeparator());
            result -= max;
        } else if (result < min) {
            setOverflows(min + System.lineSeparator());
            result -= min;
        }
        return result;
    }
}
