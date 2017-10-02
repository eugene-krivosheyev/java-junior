package com.acme.edu.logger2.core.controller;

import com.acme.edu.logger2.core.format.LoggerFormatter;
import com.acme.edu.logger2.core.format.PrefixAdder;
import com.acme.edu.logger2.core.message.Message;
import com.acme.edu.logger2.core.saver.ConsolePrinter;
import com.acme.edu.logger2.core.saver.LoggerSaver;

/**
 * Class that proceeds all incoming messages
 */

public class LoggerController {
    private final LoggerFormatter loggerFormatter = new PrefixAdder();
    private final LoggerSaver loggerSaver = new ConsolePrinter();
    private Message previousMessage = null;

    /**
     * Notifies new message about previous message,
     * loggerSaver and loggerFormatter realisations.
     *
     * @param message Message to goToFormatterAndSaver
     */
    public void proceedMessage(Message message) {
        message.setFormatterAndSaver(loggerSaver, loggerFormatter);
        if (previousMessage != null){
            message.proceed(previousMessage);
        }
        previousMessage = message;
    }


    public void stop() {
        previousMessage.stop();
        previousMessage = null;
    }
}
