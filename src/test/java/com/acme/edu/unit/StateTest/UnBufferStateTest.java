package com.acme.edu.unit.StateTest;

import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.FilePrinter;
import com.acme.edu.states.LoggerState;
import com.acme.edu.states.UnBufferState;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Павел on 07.11.2015.
 */
public class UnBufferStateTest {
    private ConsolePrinter consolePrinterMock;
    private FilePrinter filePrinterMock;
    private LoggerState sut;

    //region given
    @Before
    public void setUp() throws IOException {
        consolePrinterMock = mock(ConsolePrinter.class);
        filePrinterMock = mock(FilePrinter.class);
        sut = new UnBufferState(consolePrinterMock, filePrinterMock);

    }

    @Test
    public void shouldLogArrayAndMatrixWhenPrintArrayAndMatrix() throws Exception{

        //region given
        Object dummy = new Object();
        //endregion

        //region when
        sut.log(String.valueOf('t'));
        sut.log(String.valueOf(true));
        sut.log(String.valueOf(dummy));
        //endregion

        //region then
        verify(consolePrinterMock).print("t");
        verify(consolePrinterMock).print("true");
        verify(consolePrinterMock).print(String.valueOf(dummy));

        //endregion
    }
}
