package com.acme.edu.saver;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
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

    @Test
    public void shouldNotSaveWhenMessageIsNull() {
        String dummyMessage = null;

        loggerSaver.save(dummyMessage);

        assertSysoutEquals("");
    }

    @Test
    public void shouldPrintToSysoutWhenMessageIsNotNull() {
        String stubMessage = "message";

        loggerSaver.save(stubMessage);

        assertSysoutEquals("message" + System.lineSeparator());
    }
}