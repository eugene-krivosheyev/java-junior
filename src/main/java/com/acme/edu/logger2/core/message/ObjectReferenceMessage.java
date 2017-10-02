package com.acme.edu.logger2.core.message;

/**
 * Object reference message.
 * Contains data in "Object@xxxx" format.
 */
public class ObjectReferenceMessage extends Message implements MessagePrefix {
    /**
     * Message that contains reference to an Object
     * in "Object@xxxx" format.
     * @param message object reference
     */
    public ObjectReferenceMessage(Object message) {
        super(PREFIX_REFERENCE, message.toString());
    }

    @Override
    protected boolean isSameClass(Message message) {
        return message instanceof ObjectReferenceMessage;
    }
}
