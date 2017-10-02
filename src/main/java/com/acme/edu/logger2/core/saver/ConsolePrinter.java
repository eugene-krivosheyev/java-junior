package com.acme.edu.logger2.core.saver;

import com.acme.edu.logger2.core.message.Message;

/**
 * Prints log entries in console.
 * Simple LoggerSaver realisation.
 */
public class ConsolePrinter implements LoggerSaver {

    @Override
    public void save(Message message) {
        System.out.println(message.getContent());
    }
}
