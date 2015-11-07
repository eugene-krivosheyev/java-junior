package com.acme.edu.iteration03;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.logger.Factory;
import com.acme.edu.logger.LogException;
import com.acme.edu.logger.Logger;
import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.FilePrinter;
import com.acme.edu.printer.PrinterException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    private static final String SEP = System.lineSeparator();
    private Logger logger;
    private FilePrinter filePrinter;
    private ConsolePrinter consolePrinter;
    //region given
    @Before
    public void setUpSystemOut() throws PrinterException {
        consolePrinter = new ConsolePrinter();
        filePrinter = new FilePrinter("out.txt", "UTF-8");
        logger = new Logger(new Factory(), consolePrinter, filePrinter);
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() throws PrinterException {
        resetOut();
    }
    //endregion


    @Test
    public void shouldLogIntegersArray() throws LogException {
        //region when
        logger.log(new int[] {-1, 0, 1});
        logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "primitive: 0" + SEP
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrix() throws LogException {
        //region when
        logger.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "primitive: 0" + SEP
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws LogException {
        //region when
        logger.log(new int[][][][] {{{{0}}}});
        logger.flush();
        //endregion

        //region then
        assertSysoutEquals(
                "primitive: 0" + SEP

        );
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws LogException {
        //region when
        logger.log("str1", "string 2", "str 3");
        logger.flush();
        //endregion

        //region then
        assertSysoutContains("string: str1" + SEP + "string: string 2" + SEP + "string: str 3");
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws LogException {
        //region when
        logger.log(-1, 0, 1, 3);
        logger.flush();
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }

    @Test
     public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws LogException{
        //region when
        logger.log(1);
        logger.log("str");
        logger.log(Integer.MAX_VALUE - 10);
        logger.log(11);
        logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: " + String.valueOf(1));
        assertSysoutContains("string: str");
        assertSysoutContains("primitive: " + String.valueOf(Integer.MAX_VALUE - 10));
        assertSysoutContains("primitive: " + String.valueOf(11));
        //endregion
    }

    @Test
     public void shouldCorrectDealWithIntegerOverflow() throws LogException {
        //region when
        logger.log(1);
        logger.log("str");
        logger.log(Integer.MIN_VALUE + 10);
        logger.log(-11);
        logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: " + String.valueOf(1));
        assertSysoutContains("string: str");
        assertSysoutContains("primitive: " + String.valueOf(Integer.MIN_VALUE + 10));
        assertSysoutContains("primitive: " + String.valueOf(-11));
        //endregion
    }

}