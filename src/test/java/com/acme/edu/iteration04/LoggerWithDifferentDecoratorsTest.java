package com.acme.edu.iteration04;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.controller.LogController;
import com.acme.edu.decorator.PrefixLoggerDecorator;
import com.acme.edu.decorator.TypeLoggerDecorator;
import com.acme.edu.saver.ConsoleLoggerSaver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerWithDifferentDecoratorsTest implements SysoutCaptureAndAssertionAbility {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    @Before
    public void setUp() throws Exception {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() throws Exception {
        resetOut();
    }

    @Test
    public void shouldLogUsingTypeLoggerDecorator(){
        Logger.setController(new LogController(new ConsoleLoggerSaver(), new TypeLoggerDecorator()));
        int[] message = new int[] {1,2,3};
        Logger.log(message);
        Logger.log((byte) 7);
        Logger.log(12);
        Logger.log("some text");
        Logger.log("some text");
        Logger.log('a');
        Logger.log(true);
        Logger.log(1,2,3);
        Logger.flush();
        assertSysoutEquals("This is primitives array" + LINE_SEPARATOR +
                "This is primitive" + LINE_SEPARATOR +
                "This is primitive" + LINE_SEPARATOR +
                "This is string" + LINE_SEPARATOR +
                "This is char" + LINE_SEPARATOR +
                "This is primitive" + LINE_SEPARATOR +
                "This is primitives array" + LINE_SEPARATOR);
    }

    @Test
    public void shouldLogUsingPrefixLoggerDecorator(){
        Logger.setController(new LogController(new ConsoleLoggerSaver(), new TypeLoggerDecorator()));
        Logger.log(11923);
        Logger.log("hfhf");
        Logger.log('n');
        Logger.flush();
        assertSysoutEquals("This is primitive" + LINE_SEPARATOR +
                "This is string" + LINE_SEPARATOR +
                "This is char" + LINE_SEPARATOR);
        Logger.setController(new LogController(new ConsoleLoggerSaver(), new PrefixLoggerDecorator()));

        Logger.log(12);
        Logger.log("some text");
        Logger.log('a');
        Logger.flush();
        assertSysoutEquals("This is primitive" + LINE_SEPARATOR +
                "This is string" + LINE_SEPARATOR +
                "This is char" + LINE_SEPARATOR+
                "primitive: 12" + LINE_SEPARATOR +
                "string: some text" + LINE_SEPARATOR +
                "char: a" + LINE_SEPARATOR);
    }

}