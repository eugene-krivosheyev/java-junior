package com.acme.edu.test;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.exceptions.FileLoggerSaverException;
import com.acme.edu.exceptions.SaverException;
import com.acme.edu.saver.ConsoleLoggerSaver;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.function.ToDoubleBiFunction;

import static java.lang.System.lineSeparator;

public class ConsoleLoggerSaverTest implements SysoutCaptureAndAssertionAbility {
    private ConsoleLoggerSaver saver;

    @Before
    public void setUp() {
        saver = new ConsoleLoggerSaver();
        resetOut();
        captureSysout();
    }

    
    @Test
    public void messageIsPrintedToConsoleWhenSave() {
        saver.save("Hi!!!");

        assertSysoutEquals("Hi!!!" + lineSeparator());
    }

    //TODO Add consoleLoggerSaverException
    /*@Test(expected = SaverException.class)
    public void shouldThrowExceptionIfMessageIsNull() throws SaverException {
        saver.save(null);
    }*/
}
