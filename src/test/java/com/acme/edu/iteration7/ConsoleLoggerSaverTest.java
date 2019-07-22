package com.acme.edu.iteration7;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.command.Command;
import com.acme.edu.saver.ConsoleLoggerSaver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ConsoleLoggerSaverTest implements SysoutCaptureAndAssertionAbility {

    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @Test
    public void shouldPrintToConsoleWhenUseSave() {
        Object stub = mock(Command.class);
        when(((Command) stub)
                .messageDecorate())
                .thenReturn("string 1");
        ConsoleLoggerSaver consoleLoggerSaver = new ConsoleLoggerSaver();
        consoleLoggerSaver.save((Command) stub);
        assertSysoutEquals("string 1" + System.lineSeparator());
    }
}
