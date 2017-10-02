package com.acme.edu.logger2.core.format;

import com.acme.edu.logger2.core.message.Message;

public interface LoggerFormatter {
    /**
     * Modifies message context as needed
     * Depends on LoggerFormatter realisation
     * @param message Message to goToFormatterAndSaver
     */
    void format(Message message);
}
