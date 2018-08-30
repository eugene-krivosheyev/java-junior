package com.acme.edu.unittests;

import com.acme.edu.ConsoleLoggerSaver;
import com.acme.edu.loggerexceptions.LoggerSaverException;
import com.acme.edu.Saver;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ConsoleLoggerSaverTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion
    @Test
    public void shouldSaveString() throws LoggerSaverException {
        Saver saver = new ConsoleLoggerSaver();
        String output = "test output";
        saver.save(output);
        assertSysoutEquals("test output");
    }

    @Test (expected = LoggerSaverException.class)
    public void shouldNotSaveNull() throws LoggerSaverException {
        Saver saver = new ConsoleLoggerSaver();
        String output = null;
        saver.save(output);
        assertSysoutNotEquals("null");
    }

    @Test (expected = LoggerSaverException.class)
    public void saveStringAndNull() throws LoggerSaverException {
        Saver saver = new ConsoleLoggerSaver();
        String output = "test output";
        String nullOutput = null;
        saver.save(output);
        saver.save(nullOutput);
    }
}
