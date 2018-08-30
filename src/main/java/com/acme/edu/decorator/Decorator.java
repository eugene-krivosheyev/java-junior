package com.acme.edu.decorator;

import com.acme.edu.message.Message;

/**
 * Interface for decorating message into string
 */
public interface Decorator {
    /**
     * Convert message into decorated string
     */
    String decorate(Message message);
}
