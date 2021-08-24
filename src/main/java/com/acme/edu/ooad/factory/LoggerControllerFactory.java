package com.acme.edu.ooad.factory;

import com.acme.edu.ooad.controller.LoggerController;
import com.acme.edu.ooad.processor.*;
import com.acme.edu.ooad.saver.ConsoleSaver;

public class LoggerControllerFactory {
    public static LoggerController create() {
        NumericProcessor byteProcessor = new NumericProcessor(Byte.MIN_VALUE, Byte.MAX_VALUE);
        NumericProcessor integerProcessor = new NumericProcessor(Integer.MIN_VALUE, Integer.MAX_VALUE);
        BooleanProcessor booleanProcessor = new BooleanProcessor();
        CharacterProcessor characterProcessor = new CharacterProcessor();
        ObjectProcessor objectProcessor = new ObjectProcessor();
        StringProcessor stringProcessor = new StringProcessor();
        ConsoleSaver consoleSaver = new ConsoleSaver();

        return new LoggerController(integerProcessor,
                                    byteProcessor,
                                    stringProcessor,
                                    characterProcessor,
                                    booleanProcessor,
                                    objectProcessor,
                                    consoleSaver);
    }
}
