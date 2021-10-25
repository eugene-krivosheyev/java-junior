package com.acme.edu.integration;

import com.acme.edu.Controller;
import com.acme.edu.Flusher;
import com.acme.edu.StatesDTO;
import com.acme.edu.logger.SimpleLogger;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;

public class SimpleLoggerTest {
    private final Flusher flusher = Mockito.mock(Flusher.class);
    private final Controller controller = Mockito.mock(Controller.class);
    private final SimpleLogger simpleLogger = new SimpleLogger(flusher, controller);

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
    public void testInts() {
        int[] array = {0, 4, 6, -3};
        simpleLogger.log(array);

        verifyMocks(array.length);
    }

    @Test 
    public void testBytes() {
        byte[] array = {(byte)2, (byte)-5, (byte)17};
        simpleLogger.log(array);

        verifyMocks(array.length);
    }
    
    @Test 
    public void testChars() {
        char[] array = {'a', 'b', 'c'};
        simpleLogger.log(array);

        verifyMocks(array.length);
    }
    
    @Test 
    public void testStrings() {
        String[] array = {"Hello", "world"};
        simpleLogger.log(array);

        verifyMocks(array.length);
    }
    
    @Test 
    public void testBooleans() {
        boolean[] array = {true, false, true};
        simpleLogger.log(array);

        verifyMocks(array.length);
    }
    
    @Test 
    public void testObject() {
        simpleLogger.log(new Object());

        verifyMocks(1);
    }

    private void verifyMocks(int times) {
        Mockito.verify(flusher, times(times)).flush((StatesDTO) any());
        Mockito.verify(controller, times(times)).log(any());
    }
}
