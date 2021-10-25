package com.acme.edu.integration;

import com.acme.edu.Controller;
import com.acme.edu.Flusher;
import com.acme.edu.StatesDTO;
import com.acme.edu.logger.SimpleLogger;
import org.junit.Test;
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

    @Test
    public void testForInts() {
        int[] array = {0, 4, 6, -3};
        simpleLogger.log(array);

        Mockito.verify(flusher, times(array.length)).flush((StatesDTO) any());
        Mockito.verify(controller, times(array.length)).log(any());
    }

    @Test 
    public void testForBytes() {
        byte[] array = {(byte)2, (byte)-5, (byte)17};
        simpleLogger.log(array);

        Mockito.verify(flusher, times(array.length)).flush((StatesDTO) any());
        Mockito.verify(controller, times(array.length)).log(any());
    }
    
    @Test 
    public void testForChars() {
        char[] array = {'a', 'b', 'c'};
        simpleLogger.log(array);

        Mockito.verify(flusher, times(array.length)).flush((StatesDTO) any());
        Mockito.verify(controller, times(array.length)).log(any());
    }
    
    @Test 
    public void testForStrings() {
        String[] array = {"Hello", "world"};
        simpleLogger.log(array);

        Mockito.verify(flusher, times(array.length)).flush((StatesDTO) any());
        Mockito.verify(controller, times(array.length)).log(any());
    }
    
    @Test 
    public void testForBooleans() {
        boolean[] array = {true, false, true};
        simpleLogger.log(array);

        Mockito.verify(flusher, times(array.length)).flush((StatesDTO) any());
        Mockito.verify(controller, times(array.length)).log(any());
    }
    
    @Test 
    public void testForObject() {
        simpleLogger.log(new Object());

        Mockito.verify(controller).log(any());
    }
}
