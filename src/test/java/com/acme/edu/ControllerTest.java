package com.acme.edu;

import com.acme.edu.message.DataEqualMessage;
import com.acme.edu.printer.Printer;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ControllerTest {


    @Test
    public void shouldEndLogging(){

        Printer printerStub = mock(Printer.class);
        DataEqualMessage defaultSatateStub = mock(DataEqualMessage.class);
        when(defaultSatateStub.isSameType(any(DataEqualMessage.class))).thenReturn(false);
        when(defaultSatateStub.isSum()).thenReturn(true);
        when(defaultSatateStub.isEndLogging()).thenReturn(true);
        when(defaultSatateStub.toString()).thenReturn("");
        DataEqualMessage differentSatateStub = mock(DataEqualMessage.class);
        when(differentSatateStub.toString()).thenReturn("");
        when(differentSatateStub.isEndLogging()).thenReturn(true);

        final Controller controllerSut = new Controller(printerStub);

        controllerSut.logMessage(defaultSatateStub);
        controllerSut.logMessage(differentSatateStub);


        verify(printerStub,times(1)).getMessage(defaultSatateStub);

    }

    @Test
    public void shouldSumming(){

        Printer printerStub = mock(Printer.class);
        DataEqualMessage defaultSatateStub = mock(DataEqualMessage.class);
        when(defaultSatateStub.isSameType(any(DataEqualMessage.class))).thenReturn(false);
        when(defaultSatateStub.isSum()).thenReturn(true);
        when(defaultSatateStub.isEndLogging()).thenReturn(true);
        when(defaultSatateStub.toString()).thenReturn("");
        DataEqualMessage differentSatateStub = mock(DataEqualMessage.class);
        when(differentSatateStub.toString()).thenReturn("");
        when(differentSatateStub.isEndLogging()).thenReturn(true);

        final Controller controllerSut = new Controller(printerStub);

        controllerSut.logMessage(defaultSatateStub);
        controllerSut.logMessage(differentSatateStub);


        verify(printerStub,times(1)).getMessage(defaultSatateStub);

    }

}
