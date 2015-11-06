package com.acme.edu.states;

/**
 * Created by Павел on 06.11.2015.
 */
public class StateException extends Exception{

    /**
     * Exception for states
     * @param cause
     */
    public StateException(Throwable cause) {
        super(cause);
    }
}
