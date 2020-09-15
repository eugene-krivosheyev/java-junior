package com.acme.edu.saver;

import com.acme.edu.message.AbstractMessage;

/**
 * Implementation of Saver interface for saving log messages to console.
 * @see Saver
 */
public class ConsoleSaver implements Saver {
    @Override
    public void save(AbstractMessage message) {
        System.out.println(message.getPreparedMessage());
    }

    @Override
    public void closeWriter() {};
}
