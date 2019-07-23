package com.acme.edu.unit;

import com.acme.edu.LoggerController;
import com.acme.edu.saver.Saver;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoggerControllerTest {

    @Test
    public void shouldUpdateWhenPreviousCommandNotNull() {
        Saver saverStub = mock(Saver.class);
        LoggerController loggerSut = new LoggerController(saverStub);


    }
}
