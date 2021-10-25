package com.acme.edu.logger;

import com.acme.edu.Controller;
import com.acme.edu.StatesDTO;
import com.acme.edu.Flusher;
import com.acme.edu.message.*;

public class SimpleLogger {
    private final Flusher flusher;
    private final StatesDTO statesDTO;
    private final Controller controller;

    public SimpleLogger() {
        this.flusher = new Flusher();
        this.statesDTO = new StatesDTO(flusher);
        this.controller = new Controller(statesDTO);
    }

    public void log(int... ints) {
        for (int obj : ints) {
            controller.log(new IntMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void log(byte... bytes) {
        for (byte obj : bytes) {
            controller.log(new ByteMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void log(char... characters) {
        for (char obj : characters) {
            controller.log(new CharMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void log(String... strings) {
        for (String obj : strings) {
            controller.log(new StringMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void log(boolean... bools) {
        for (boolean obj : bools) {
            controller.log(new BooleanMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void log(Object obj) {
        controller.log(new ReferenceMessage(obj));
        flusher.flush(statesDTO);
    }
}
