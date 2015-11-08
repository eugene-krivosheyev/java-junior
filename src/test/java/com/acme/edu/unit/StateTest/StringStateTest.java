package com.acme.edu.unit.StateTest;

import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.FilePrinter;
import com.acme.edu.logger.LoggerState;
import com.acme.edu.states.StringState;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Павел on 07.11.2015.
 */
public class StringStateTest {

    private ConsolePrinter consolePrinterMock;
    private FilePrinter filePrinterMock;
    private LoggerState sut;

    //region given
    @Before
    public void setUp() throws IOException {
        consolePrinterMock = mock(ConsolePrinter.class);
        filePrinterMock = mock(FilePrinter.class);
        sut = new StringState(consolePrinterMock, filePrinterMock);
    }


    @Test
    public void shouldEmptyStringWhenPrintEmpty() throws Exception{

        //region when
        sut.log("str 1");
        sut.log("");
        sut.log("str 2");
        sut.flush();
        //endregion

        //region then
        //console
        verify(consolePrinterMock).print("string: str 1");
        verify(consolePrinterMock).print("string: str 2");
        //file
        verify(filePrinterMock).print("string: str 1");
        verify(filePrinterMock).print("string: str 2");

        //endregion
    }

    @Test
    public void shouldLogStringWhenPrintCountDuplicateString() throws Exception{


        //region when
        sut.log("str 1");
        sut.log("str 2");
        sut.log("str 2");
        sut.log("str 2");
        sut.log("str 4");
        sut.log("str 3");
        sut.log("str 3");
        sut.flush();
        //endregion

        //region then
        verify(consolePrinterMock).print("string: str 1");
        verify(consolePrinterMock).print("string: str 2 (x3)");
        verify(consolePrinterMock).print("string: str 4");
        verify(consolePrinterMock).print("string: str 3 (x2)");
        verify(filePrinterMock).print("string: str 3 (x2)");
        //endregion
    }

}
