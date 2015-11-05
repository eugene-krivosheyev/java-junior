package com.acme.edu;

/**
 * Factory conditions
 */
public class Factory {

    //region fields

    private IntState intState;
    private StringState stringState;
    private UnBufferState unBufferState;

    //region constructor

    /**
     * Initialization States
     * @param intState
     * @param stringState
     * @param unBufferState
     */
    public Factory(IntState intState, StringState stringState, UnBufferState unBufferState) {
        this.intState = intState;
        this.stringState = stringState;
        this.unBufferState = unBufferState;
    }
    //endregion

    /**
     *
     * @return IntState
     */
    public IntState getIntState() {
        return intState;
    }

    /**
     *
     * @return StringState
     */
    public StringState getStringState() {
        return stringState;
    }

    /**
     *
     * @return State without buffer
     */
    public UnBufferState getUnBufferState() {
        return unBufferState;
    }
}
