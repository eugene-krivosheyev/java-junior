package com.acme.edu;

import com.acme.edu.accumulator.MessageAccumulator;
import com.acme.edu.container.MessageContainer;
import com.acme.edu.decorator.MessageDecorator;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.LoggerSaver;

import java.util.ArrayList;

public class LoggerController {
    private ArrayList<MessageContainer> messages;
    private MessageDecorator decorator;
    private MessageAccumulator accumulator;
    private LoggerSaver saver;

    public LoggerController(MessageDecorator decorator, MessageAccumulator accumulator, LoggerSaver saver) {
        this.decorator = decorator;
        this.accumulator = accumulator;
        this.saver = saver;
    }

    public void log(MessageContainer message) {
        messages.add(message);
    }

    public void flush() {
        messages = accumulator.accumulate(messages);
        String message = decorator.decorate(messages);
        saver.save(message);
    }

}
