package com.acme.edu.controller;

import com.acme.edu.Logger;
import com.acme.edu.dto.StatesDTO;
import com.acme.edu.flush.Flusher;
import com.acme.edu.message.*;

public class SimpleController {
    private final Flusher flusher;
    private final StatesDTO statesDTO;
    private final Logger logger;

    public SimpleController() {
        this.flusher = new Flusher();
        this.statesDTO = new StatesDTO(flusher);
        this.logger = new Logger(statesDTO);
    }

    public void perform(int... ints) {
        for (int obj : ints) {
            logger.log(new IntMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void perform(byte... bytes) {
        for (byte obj : bytes) {
            logger.log(new ByteMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void perform(char... characters) {
        for (char obj : characters) {
            logger.log(new CharMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void perform(String... strings) {
        for (String obj : strings) {
            logger.log(new StringMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void perform(boolean... bools) {
        for (boolean obj : bools) {
            logger.log(new BooleanMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void perform(Object obj) {
        logger.log(new ReferenceMessage(obj));
        flusher.flush(statesDTO);
    }
}
