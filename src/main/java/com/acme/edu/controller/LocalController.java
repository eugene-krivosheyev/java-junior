package com.acme.edu.controller;

import com.acme.edu.buffer.LinkedListQueueLogBuffer;
import com.acme.edu.buffer.LogBuffer;
import com.acme.edu.commands.Command;
import com.acme.edu.saver.Saver;

import java.io.IOException;

public class LocalController implements Controller {
    private final static String PREFIX_PRIMITIVE = "primitive: ";
    private final static String PREFIX_PRIMITIVES_ARRAY = "primitives array: ";
    private final static String PREFIX_CHAR = "char: ";
    private final static String PREFIX_STRING = "string: ";
    private final static String PREFIX_REFERENCE = "reference: ";

    private int count = 0;
    private String loggedString = "";

    Command lastCommand = null;

    private Saver saver;
    protected LogBuffer logBuffer;

    public LocalController(Saver saver, LogBuffer buffer) {
        this.saver = saver;
        logBuffer = buffer;
    }

    public LocalController(Saver saver) {
        this.saver = saver;
        logBuffer = new LinkedListQueueLogBuffer();
    }

    public void log(Command command) {
        logBuffer.bufferizeLog(command);
    }

    public void flush() {
        try {
            logBuffer.flush(saver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void flushUnsafe() throws IOException {
        logBuffer.flush(saver);
    }
}
