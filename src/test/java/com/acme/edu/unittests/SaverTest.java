package com.acme.edu.unittests;

import com.acme.edu.exceptions.SaverException;
import com.acme.edu.savers.ConsoleSaver;
import com.acme.edu.savers.Saver;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class SaverTest {
    @Test
    public void shouldCallSystemOutPrintLnWhenSaving() throws SaverException, IOException {
        Saver mockSaver = mock(ConsoleSaver.class);

        doCallRealMethod().when(mockSaver).save("message");

        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        mockSaver.save("message");

        verify(out, times(1));
    }
}
