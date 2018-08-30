package com.acme.edu.iteration04;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.loggerexceptions.MessageException;
import com.acme.edu.loggerexceptions.SaverExceptions;
import com.acme.edu.saver.ConsoleLoggerSaver;
import com.acme.edu.saver.LoggerSaver;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
@Ignore
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

    @Test (expected = MessageException.class)
    public void checkNullMessageEmptyOutputTest() throws SaverExceptions {
        LoggerSaver loggerSaver = new ConsoleLoggerSaver();
        loggerSaver.save(null);
        assertSysoutEquals("");
    }
}
