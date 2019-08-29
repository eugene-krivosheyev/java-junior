package com.acme.edu.unittests;

import com.acme.edu.LoggerController;
import com.acme.edu.commands.AccumulateCommand;
import com.acme.edu.commands.CharCommand;
import com.acme.edu.commands.PrimitiveCommand;
import com.acme.edu.exceptions.SaverException;
import com.acme.edu.savers.ConsoleSaver;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import static org.mockito.Mockito.*;

public class LoggerControllerTest {
    @Test
    public void shouldFlushWhenCloseAndPrevCommandNotNull() throws SaverException {
        PrimitiveCommand stubIntCommand = mock(PrimitiveCommand.class);
        Whitebox.setInternalState(stubIntCommand, "buffer", "1");
        ConsoleSaver dummySaver = mock(ConsoleSaver.class);

        final LoggerController sut = new LoggerController(dummySaver);
        sut.run(stubIntCommand);
        sut.close();

        verify(stubIntCommand).flush(dummySaver);
    }

    @Test
    public void shouldNotFlushWhenCloseAndPrevCommandNull() throws SaverException {
        PrimitiveCommand stubIntCommand = mock(PrimitiveCommand.class);
        ConsoleSaver dummySaver = mock(ConsoleSaver.class);

        final LoggerController sut = new LoggerController(dummySaver);
        sut.close();

        doNothing().when(stubIntCommand).flush(dummySaver);
    }
}
