package com.acme.edu.unit.StateTest;

import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.FilePrinter;
import com.acme.edu.printer.RemotePrinter;
import com.acme.edu.states.IntState;
import com.acme.edu.logger.LoggerState;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

/**
 * Created by Павел on 07.11.2015.
 */
public class IntStateTest {
    private ConsolePrinter consolePrinterMock;
    private FilePrinter filePrinterMock;
    private RemotePrinter remotePrinter;
    private LoggerState sut;

    @Before
    public void setUp() throws IOException {
        consolePrinterMock = mock(ConsolePrinter.class);
        filePrinterMock = mock(FilePrinter.class);
        remotePrinter = mock(RemotePrinter.class);

        sut = new IntState(consolePrinterMock, filePrinterMock, remotePrinter);
    }

    @Test
    public void shouldLogSequentWhenPrintSum() throws Exception {

        //region when + then
        sut.log("1");
        sut.log("0");
        sut.log("-1");
        sut.flush();

        //console
        verify(consolePrinterMock).print("primitive: 0");

        //file
        verify(filePrinterMock).print("primitive: 0");
        //endregion

        verify(remotePrinter).print("primitive: 0");
    }

    @Test
    public void shouldLogIntegerMinAndMaxWhenPrintIntegerMinAndMax() throws Exception{

        //region when
        sut.log("1");
        sut.log(String.valueOf(Integer.MAX_VALUE));
        sut.log(String.valueOf(Integer.MIN_VALUE));
        sut.flush();
        sut.log(String.valueOf(Integer.MAX_VALUE - 10));
        sut.log(String.valueOf(11));
        sut.flush();
        sut.log(String.valueOf(Integer.MIN_VALUE + 10));
        sut.log(String.valueOf(-11));
        sut.flush();
        //endregion

        //region then
        //console
        verify(consolePrinterMock).print("primitive: " + 1);
        verify(consolePrinterMock).print("primitive: " + Integer.MAX_VALUE);
        verify(consolePrinterMock).print("primitive: " + Integer.MIN_VALUE);
        verify(consolePrinterMock).print("primitive: " + String.valueOf(Integer.MAX_VALUE - 10));
        verify(consolePrinterMock).print("primitive: " + 11);
        verify(consolePrinterMock).print("primitive: " + String.valueOf(Integer.MIN_VALUE + 10));
        verify(consolePrinterMock).print("primitive: " + -11);
        //endregion
    }
}
