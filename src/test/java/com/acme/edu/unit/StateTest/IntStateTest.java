package com.acme.edu.unit.StateTest;

import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.FilePrinter;
import com.acme.edu.states.IntState;
import com.acme.edu.states.LoggerState;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Павел on 07.11.2015.
 */
public class IntStateTest {
    private ConsolePrinter consolePrinterMock;
    private FilePrinter filePrinterMock;
    private LoggerState sut;

    @Before
    public void setUp() throws IOException {
        consolePrinterMock = mock(ConsolePrinter.class);
        filePrinterMock = mock(FilePrinter.class);
        sut = new IntState(consolePrinterMock, filePrinterMock);
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
