package com.acme.edu.ooad.controller;

import com.acme.edu.ooad.message.ObjectMessage;
import com.acme.edu.ooad.processor.*;
import com.acme.edu.ooad.saver.ConsoleSaver;

public class LoggerController {
    private final NumericProcessor integerProcessor;
    private final NumericProcessor byteProcessor;
    private final StringProcessor stringProcessor;
    private final CharacterProcessor characterProcessor;
    private final BooleanProcessor booleanProcessor;
    private final ObjectProcessor objectProcessor;
    private final ConsoleSaver consoleSaver;

    private Processor lastProcessor;

    public LoggerController(NumericProcessor integerProcessor,
                            NumericProcessor byteProcessor,
                            StringProcessor stringProcessor,
                            CharacterProcessor characterProcessor,
                            BooleanProcessor booleanProcessor,
                            ObjectProcessor objectProcessor, ConsoleSaver consoleSaver) {
        this.integerProcessor = integerProcessor;
        this.byteProcessor = byteProcessor;
        this.stringProcessor = stringProcessor;
        this.characterProcessor = characterProcessor;
        this.booleanProcessor = booleanProcessor;
        this.objectProcessor = objectProcessor;
        this.consoleSaver = consoleSaver;
    }

    public void log(int message) {
        checkLastProcessor(integerProcessor);
        integerProcessor.process(message);
    }

    public void log(int... messages) {
        checkLastProcessor(integerProcessor);
        integerProcessor.process(messages);
    }

    public void log(byte message) {
        checkLastProcessor(byteProcessor);
        byteProcessor.process(message);
    }

    public void log(String message) {
        checkLastProcessor(stringProcessor);
        saveLogs(stringProcessor.process(message));
    }

    public void log(String... messages) {
        checkLastProcessor(stringProcessor);
        saveLogs(stringProcessor.process(messages));
    }

    public void log(char message) {
        checkLastProcessor(characterProcessor);
        saveLogs(characterProcessor.process(message));
    }

    public void log(boolean message) {
        checkLastProcessor(booleanProcessor);
        saveLogs(booleanProcessor.process(message));
    }

    public void log(Object message) {
        checkLastProcessor(objectProcessor);
        saveLogs(objectProcessor.process(message));
    }

    private void checkLastProcessor(Processor processor) {
        if ( lastProcessor != processor ) {
            flush();
            lastProcessor = processor;
        }
    }

    public void flush() {
        if ( lastProcessor == null ) return;
        flushAndSaveLogs(lastProcessor);
        lastProcessor = null;
    }

    void flushAndSaveLogs(Processor processor) {
        saveLogs(processor.flush());
    }

    void saveLogs(ObjectMessage[] logs) {
        if ( logs == null || logs.length < 1 ) return;
        for (var log : logs ) {
            consoleSaver.save(log);
        }
    }
}
