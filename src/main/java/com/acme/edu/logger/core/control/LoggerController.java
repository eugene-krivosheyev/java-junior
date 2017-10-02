package com.acme.edu.logger.core.control;

import com.acme.edu.logger.core.control.queues.GeneralMessagesQueue;
import com.acme.edu.logger.core.message.*;
import com.acme.edu.logger.core.message.x.ArrayMessage;
import com.acme.edu.logger.core.planning.LoggerConfiguration;

/**
 * Control workflow.
 */
public class LoggerController {

    /**
     * Configuration for work.
     */
    private LoggerConfiguration config;

    /**
     *
     */
    private GeneralMessagesQueue[][] generalQueue;

    /**
     * Current active state of logger machine.
     */
    private State activeState;

    /**
     * Previous state of logger machine.
     */
    private State previousState;

    /**
     * State of logger machine.
     */
    private enum State { INIT, START, RUN, PAUSE, STOP }

    /**
     * Constructor.
     */
    public LoggerController() {
        activeState   = State.INIT;
        generalQueue = new GeneralMessagesQueue[10][];

        if ( config.isLogMessageTypesWillChanged() ) {

        }

    }

    /**
     * Set the main configuration for logger.
     * @param config configuration.
     */
    public void setConfig(LoggerConfiguration config) {
        this.config = config;
    }

    /** Start the workflow. */
    public void start() {
        previousState = activeState;
        activeState   = State.START;
        run();
    }

    /** Running the workflow. */
    private void run() {
        previousState = activeState;
        activeState   = State.RUN;
    }

    /** Stop the workflow. */
    public void stop() {
        previousState = activeState;
        activeState   = State.STOP;
    }

    /**
     * Accept the messages with content of primitive boolean values.
     * @param message message.
     */
    public void acceptMessage(BooleanMessage message) {

    }

    /**
     * Accept the messages with content of primitive byte values.
     * @param message message
     */
    public void acceptMessage(ByteMessage message) {

    }

    /**
     * Accept the messages with content of primitive short values.
     * @param message message
     */
    public void acceptMessage(ShortMessage message) {

    }

    /**
     * Accept the messages with content of primitive integer values.
     * @param message message
     */
    public void acceptMessage(IntegerMessage message) {

    }

    /**
     * Accept the messages with content of primitive long values.
     * @param message message
     */
    public void acceptMessage(LongMessage message) {

    }

    /**
     * Accept the messages with content of primitive char values.
     * @param message message
     */
    public void acceptMessage(CharMessage message) {

    }

    /**
     * Accept the messages with content of string values.
     * @param message message
     */
    public void acceptMessage(StringMessage message) {

    }

    /**
     * Accept the messages with content of object reference values.
     * @param message message
     */
    public void acceptMessage(ObjectReferenceMessage message) {

    }

    /**
     * Accept the messages with content of array primitive values.
     * @param message message
     */
    public void acceptMessage(ArrayMessage[] message) {

    }
}

/*

if ( typesWillChanged ) accumulateContent = true;

if ( accumulateContent ) checkOverflowOfIntegers();

 */
