package com.acme.edu.saver;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.loggerexceptions.MessageException;
import com.acme.edu.loggerexceptions.SaverExceptions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsoleLoggerSaverTest implements SysoutCaptureAndAssertionAbility {
    private ConsoleLoggerSaver loggerSaver;

    @Before
    public void setUp() throws Exception {
        resetOut();
        captureSysout();
        loggerSaver = new ConsoleLoggerSaver();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test (expected = MessageException.class)
    public void shouldNotSaveWhenMessageIsNull() throws SaverExceptions {
        String dummyMessage = null;

        loggerSaver.save(dummyMessage);

        assertSysoutEquals("");
    }

    @Test
    public void shouldPrintToSysoutWhenMessageIsNotNull() throws SaverExceptions {
        String stubMessage = "message";

        loggerSaver.save(stubMessage);

        assertSysoutEquals("message" + System.lineSeparator());
    }
}