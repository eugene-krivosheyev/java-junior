package com.acme.edu;

import com.acme.edu.Logger.LoggingType;
import com.acme.edu.Saver.Saver;

public class Controller {
    private final static String PREFIX_PRIMITIVE = "primitive: ";
    private final static String PREFIX_PRIMITIVES_ARRAY = "primitives array: ";
    private final static String PREFIX_CHAR = "char: ";
    private final static String PREFIX_STRING = "string: ";
    private final static String PREFIX_REFERENCE = "reference: ";

    private int sum = 0;
    private long maxValue = 0;

    private int count = 0;
    private String loggedString = "";

    private LoggingType lastType = LoggingType.NOTHING;

    private Saver saver;

    public Controller(Saver saver) {
        this.saver = saver;
    }

    public void logArray(Command command) {
        saver.save(command.decorate());
    }

    public void logPrimitive(int message) {

    }



}
