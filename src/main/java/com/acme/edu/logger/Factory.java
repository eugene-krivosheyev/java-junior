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
     */
    public Factory() {
        this.intState = new IntState();
        this.stringState = new StringState();
        this.unBufferState = new UnBufferState();
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
     * @return State without buffer
     */
    public UnBufferState getUnBufferState() {
        return unBufferState;
    }

}
