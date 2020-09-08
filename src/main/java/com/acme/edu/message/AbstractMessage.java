package com.acme.edu.message;

import java.util.ArrayList;

/**
 * Abstract class for any message type that we want to log.
 * Supports prefix for messages, e.g. type description, and
 * message view handler that should be specified for every
 * message type.
 */
public abstract class AbstractMessage {
    static public String PREFIX = "";
    public StringBuilder messageController = new StringBuilder();

    public abstract void prepareMessage(ArrayList<Object> listOfLog);
}
