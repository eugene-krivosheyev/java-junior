package com.acme.edu.processors;

import com.acme.edu.messageOut.Formatter;

public class ServiceForIntAndByte {
    private Formatter formatter;
    private String type;
    private String previousType;

    public ServiceForIntAndByte(Formatter formatter){
        this.formatter = formatter;
    }
    public String getType() {
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public String getPreviousType() {
        return previousType;
    }
    public void setPreviousType(String previousType){
        this.previousType = previousType;
    }
    public void processingForIntAndByte(int message) {
        formatter.setMessagePrefix("primitive: ");
        int maxValue = (type == "int") ? Integer.MAX_VALUE : Byte.MAX_VALUE;
        if (type != previousType) {
            flush();
            previousType = type;
            bufferSum += message;
        } else {
            if ((Long.valueOf(bufferSum) + Long.valueOf(message)) < maxValue) {
                bufferSum += message;
            } else {
                printer.print(formatter.formatMessage(maxValue));
                bufferSum = message - (maxValue - bufferSum);
            }
        }
    }
}
