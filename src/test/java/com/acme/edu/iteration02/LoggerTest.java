package com.acme.edu.iteration02;


import com.acme.edu.*;
import com.acme.edu.logger.LogException;
import com.acme.edu.logger.Factory;
import com.acme.edu.logger.Logger;
import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.FilePrinter;
import com.acme.edu.printer.Printable;
import com.acme.edu.printer.PrinterException;
import com.acme.edu.states.IntState;
import com.acme.edu.states.StringState;
import com.acme.edu.states.UnBufferState;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    private static final String SEP = System.lineSeparator();
    private Logger logger;

    //region given
    @Before
    public void setUpSystemOut() throws PrinterException {
        ConsolePrinter consolePrinter = new ConsolePrinter();
        FilePrinter filePrinter = new FilePrinter("out.txt", "UTF-8");
        logger = new Logger(new Factory(new IntState(consolePrinter, filePrinter),
                                        new StringState(consolePrinter, filePrinter),
                                        new UnBufferState(consolePrinter, filePrinter)));
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion


    @Test
    public void shouldLogSequentIntegersAsSum() throws LogException {
        //region when
        logger.log("str 1");
        logger.log(1);
        logger.log(2);
        logger.log("str 2");
        logger.log(0);
        logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "string: str 1" + SEP +
                        "primitive: 3" + SEP +
                        "string: str 2" + SEP +
                        "primitive: 0" + SEP
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws LogException {
        //region when
        logger.log("str 1");
        logger.log(10);
        logger.log(Integer.MAX_VALUE);
        logger.log("str 2");
        logger.log(0);
        logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "string: str 1" + SEP +
                        "primitive: 10" + SEP +
                        "primitive: " + Integer.MAX_VALUE + SEP +
                        "string: str 2" + SEP +
                        "primitive: 0" + SEP
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenPreviousInteger() throws  LogException {
        //region when
        logger.log("str 1");
        logger.log(-10);
        logger.log(Integer.MIN_VALUE);
        logger.log("str 2");
        logger.log(0);
        logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "string: str 1" + SEP +
                        "primitive: -10" + SEP +
                        "primitive: " + Integer.MIN_VALUE + SEP +
                        "string: str 2" + SEP +
                        "primitive: 0" + SEP
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws LogException {
        //region when
        logger.log("str 1");
        logger.log("str 2");
        logger.log("str 2");
        logger.log(0);
        logger.log("str 2");
        logger.log("str 3");
        logger.log("str 3");
        logger.log("str 3");
        logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + SEP +
            "string: str 2 (x2)" + SEP +
            "primitive: 0" + SEP +
            "string: str 2" + SEP +
            "string: str 3 (x3)"+ SEP
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutMultiRepeat() throws LogException {
        //region when
        logger.log("str 2");
        logger.log("str 2");
        logger.log("str 3");
        logger.log("str 2");
        logger.log(1);
        logger.log(2);
        logger.log("str 2");
        logger.log(0);
        logger.log("str 2");
        logger.log("str 3");
        logger.log("str 3");
        logger.log("str 3");
        logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
                        "string: str 2 (x2)" + SEP +
                        "string: str 3" + SEP +
                        "string: str 2" + SEP +
                        "primitive: 3" + SEP +
                        "string: str 2" + SEP +
                        "primitive: 0" + SEP +
                        "string: str 2" + SEP +
                        "string: str 3 (x3)" + SEP
        );
    }
}