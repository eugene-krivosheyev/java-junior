package com.acme.edu.logger.core.message;

/** Common message type. */
public abstract class Message {

    /** */
    protected enum MessageType { BOOLEAN, BYTE, SHORT, INT, LONG, CHAR, STRING, OBJECT, OTHER }

    /** */
    protected enum MessageArrayTypes { PRIMITIVE, CHAR, STRING, OBJECT, OTHER }

    /** */
    protected enum MessageVarangTypes { PRIMITIVE, CHAR, STRING, OBJECT, OTHER}
}
