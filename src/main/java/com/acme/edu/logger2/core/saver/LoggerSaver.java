package com.acme.edu.logger2.core.saver;

import com.acme.edu.logger2.core.message.Message;

public interface LoggerSaver {
    /**
     * Save or print message
     * Depends on LoggerServer realisation
     * @param message Message to goToFormatterAndSaver
     */
    void save(Message message);
}
