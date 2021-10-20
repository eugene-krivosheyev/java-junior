package com.acme.edu;

public class Stater {

    private String type;
    private String previousType;
    private int bufferSum;
    private String bufferString;
    private int stringCounter;

    public Stater(String type, String previousType, int bufferSum, String bufferString, int stringCounter){
        this.type = type;
        this.previousType = previousType;
        this.bufferString = bufferString;
        this.bufferSum = bufferSum;
        this.stringCounter = stringCounter;
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

    public int getBufferSum(){
        return bufferSum;
    }

    public void setBufferSum(int bufferSum){
        this.bufferSum = bufferSum;
    }

    public String getBufferString(){
        return bufferString;
    }

    public void setBufferString(String bufferString){
        this.bufferString = bufferString;
    }

    public int getStringCounter(){
        return stringCounter;
    }

    public void setStringCounter(int stringCounter){
        this.stringCounter = stringCounter;
    }

}
