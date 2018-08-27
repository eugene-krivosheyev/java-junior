package com.acme.edu.loggersaver;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.saver.ConsoleLoggerSaver;
import com.acme.edu.saver.LoggerSaver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class LoggerSaverTest implements SysoutCaptureAndAssertionAbility {
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    
    @Test
    public void checkNullMessageTest() {
        LoggerSaver loggerSaver = new ConsoleLoggerSaver();
        assertTrue(loggerSaver.checkNull(null));
    }

    @Test
    public void checkNullMessageEmptyOutputTest() {
        LoggerSaver loggerSaver = new ConsoleLoggerSaver();
        loggerSaver.save(null);
        assertSysoutEquals("");
    }
}
