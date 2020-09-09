package com.acme.edu.test;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.saver.ConsoleLoggerSaver;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ConsoleLoggerSaverTest implements SysoutCaptureAndAssertionAbility {
    private ConsoleLoggerSaver saver;

    @Before
    public void setUp() {
        saver = new ConsoleLoggerSaver();
    }

    @Ignore
    @Test
    public void messageIsPrintedToConsoleWhenSave() {
        saver.save("Hi!!!");

        assertSysoutEquals("Hi!!!");
    }
}
