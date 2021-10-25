package com.acme.edu.logger;

import com.acme.edu.Logger;
import com.acme.edu.StatesDTO;
import com.acme.edu.Flusher;
import com.acme.edu.message.*;

public class ComplexLogger {
    private final Flusher flusher;
    private final StatesDTO statesDTO;
    private final Logger logger;

    public ComplexLogger() {
        this.flusher = new Flusher();
        this.statesDTO = new StatesDTO(flusher);
        this.logger = new Logger(statesDTO);
    }

    public void log(Object... objects) {
        for (Object obj : objects) {
            if (obj instanceof String) {
                logger.log(new StringMessage((String) obj));
            } else if (obj instanceof Integer) {
                logger.log(new IntMessage((int) obj));
            } else if (obj instanceof Byte) {
                logger.log(new ByteMessage((byte) obj));
            }
        }
        flusher.flush(statesDTO);
    }

    public void log(int[] array) {
        logger.log(new ArrayMessage(array));
        flusher.flush(statesDTO);
    }

    public void log(int[][] matrix) {
        logger.log(new MatrixMessage(matrix));
        flusher.flush(statesDTO);
    }
}
