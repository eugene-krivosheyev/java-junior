package com.acme.edu.saver;

import com.acme.edu.message.AbstractMessage;

/**
 * Common interface for saving log messages to specific locations.
 */
public interface Saver {
    /**
     * @param message AbstractMessage to be saved
     * @see AbstractMessage
     */
    void save(AbstractMessage message);
}
