package com.acme.edu.logger;

import com.acme.edu.states.IntState;
import com.acme.edu.states.StringState;
import com.acme.edu.states.UnBufferState;

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
     * @return IntState - the sum of integers
     */
    public IntState getIntState() {
        return intState;
    }

    /**
     * @return StringState - duplicate rows
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
