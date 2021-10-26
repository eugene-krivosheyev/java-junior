package com.acme.edu.integration;

import com.acme.edu.Controller;
import com.acme.edu.Flusher;
import com.acme.edu.StatesDTO;
import com.acme.edu.logger.ComplexLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;

public class ComplexLoggerTest {
    private final Flusher flusher = Mockito.mock(Flusher.class);
    private final Controller controller = Mockito.mock(Controller.class);
    private final ComplexLogger complexLogger = new ComplexLogger(flusher, controller);

    @BeforeEach
    public void initMocks() {
        Mockito.doNothing().when(flusher).flush((StatesDTO) any());
        Mockito.doNothing().when(controller).log(any());
    }

    @AfterEach
    public void resetMocks() {
        Mockito.reset();
    }

    @Test
    public void testObjects() {
        Object[] stringsIntsBytes = {"string", (byte) 3, 45, 2, (byte) -3, "string", "string"};
        complexLogger.log(stringsIntsBytes);

        verifyMocks(stringsIntsBytes.length);
    }

    @Test
    public void testArray() {
        int[] array = {0, 6, -32};
        complexLogger.log(array);

        verifyMocks(1);
    }

    @Test
    public void testMatrix() {
        int[][] matrix = {{1, 0}, {-67, 100}};
        complexLogger.log(matrix);

        verifyMocks(1);
    }

    private void verifyMocks(int timesController) {
        Mockito.verify(flusher).flush((StatesDTO) any());
        Mockito.verify(controller, times(timesController)).log(any());
    }
}
