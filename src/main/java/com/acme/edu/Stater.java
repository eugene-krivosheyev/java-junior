package com.acme.edu;

public class Stater {

    public enum TypeVar {
        INIT_STATE,
        INT_STATE,
        BYTE_STATE,
        STRING_STATE,
        DEFAULT_STATE;
    }

    private TypeVar type;
    private TypeVar previousType;
    private int bufferSum;
    private String bufferString;
    private int stringCounter;

    public Stater(TypeVar type, TypeVar previousType, int bufferSum, String bufferString, int stringCounter){
        this.type = type;
        this.previousType = previousType;
        this.bufferString = bufferString;
        this.bufferSum = bufferSum;
        this.stringCounter = stringCounter;
    }

    public TypeVar getType() {
        return type;
    }
    public void setType(TypeVar type){
        this.type = type;
    }

    public TypeVar getPreviousType() {
        return previousType;
    }
    public void setPreviousType(TypeVar previousType){
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
