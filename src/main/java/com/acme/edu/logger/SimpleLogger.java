package com.acme.edu.logger;

import com.acme.edu.Controller;
import com.acme.edu.StatesDTO;
import com.acme.edu.Flusher;
import com.acme.edu.message.*;

public class SimpleLogger {
    private final Flusher flusher;
    private final StatesDTO statesDTO;
    private final Controller logger;

    public SimpleLogger() {
        this.flusher = new Flusher();
        this.statesDTO = new StatesDTO(flusher);
        this.logger = new Controller(statesDTO);
    }

    public void log(int... ints) {
        for (int obj : ints) {
            logger.log(new IntMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void log(byte... bytes) {
        for (byte obj : bytes) {
            logger.log(new ByteMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void log(char... characters) {
        for (char obj : characters) {
            logger.log(new CharMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void log(String... strings) {
        for (String obj : strings) {
            logger.log(new StringMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void log(boolean... bools) {
        for (boolean obj : bools) {
            logger.log(new BooleanMessage(obj));
            flusher.flush(statesDTO);
        }
    }

    public void log(Object obj) {
        logger.log(new ReferenceMessage(obj));
        flusher.flush(statesDTO);
    }
}
