package com.acme.edu;

import com.acme.edu.Commands.Command;
import com.acme.edu.Commands.IntArrayCommand;
import com.acme.edu.Saver.Saver;

public class Controller {
    private final static String PREFIX_PRIMITIVE = "primitive: ";
    private final static String PREFIX_PRIMITIVES_ARRAY = "primitives array: ";
    private final static String PREFIX_CHAR = "char: ";
    private final static String PREFIX_STRING = "string: ";
    private final static String PREFIX_REFERENCE = "reference: ";

    private int count = 0;
    private String loggedString = "";

    Command command = null;

    private Saver saver;

    public Controller(Saver saver) {
        this.saver = saver;
    }

    public void log(Command command) {

        saver.save(command.flush());
    }


    public void logPrimitive(IntArrayCommand command) {

    }




}
