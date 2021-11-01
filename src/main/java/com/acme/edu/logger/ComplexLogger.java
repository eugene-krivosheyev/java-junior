package com.acme.edu.logger;

import com.acme.edu.Controller;
import com.acme.edu.Flusher;
import com.acme.edu.StatesDTO;
import com.acme.edu.message.*;

public class ComplexLogger {
    private final Flusher flusher;
    private final StatesDTO statesDTO;
    private final Controller controller;

    public ComplexLogger() {
        this.flusher = new Flusher();
        this.statesDTO = new StatesDTO(flusher);
        this.controller = new Controller(statesDTO);
    }

    public ComplexLogger(Flusher flusher, Controller controller) {
        this.flusher = flusher;
        this.statesDTO = new StatesDTO(flusher);
        this.controller = controller;
    }

    public void log(Object... objects) {
        for (Object obj : objects) {
            if (obj instanceof String) {
                controller.log(new StringMessage((String) obj));
            } else if (obj instanceof Integer) {
                controller.log(new IntMessage((int) obj));
            } else if (obj instanceof Byte) {
                controller.log(new ByteMessage((byte) obj));
            }
        }
        flusher.flush(statesDTO);
    }

    public void log(int[] array) {
        controller.log(new ArrayMessage(array));
        flusher.flush(statesDTO);
    }

    public void log(int[][] matrix) {
        controller.log(new MatrixMessage(matrix));
        flusher.flush(statesDTO);
    }
}
