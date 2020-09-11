package com.acme.edu.iteration02;

import com.acme.edu.LoggerFacade;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.exception.LoggerControllerException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;

public class LoggerFacadeTest implements SysoutCaptureAndAssertionAbility {
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
    public void shouldLogSequentIntegersAsSum() throws LoggerControllerException {
        //region when
        LoggerFacade.log("str 1");
        LoggerFacade.log(1);
        LoggerFacade.log(2);
        LoggerFacade.log("str 2");
        LoggerFacade.log(0);
        LoggerFacade.flushStart();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + lineSeparator() +
            "primitive: 3" + lineSeparator() +
            "string: str 2" + lineSeparator() +
            "primitive: 0" + lineSeparator()
        );
        //endregion
    }




    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws LoggerControllerException {
        //region when
        LoggerFacade.log("str 1");
        LoggerFacade.flushStart();
        LoggerFacade.log(10);
        LoggerFacade.log(Integer.MAX_VALUE-1);
        LoggerFacade.log(Integer.MAX_VALUE-2);
        LoggerFacade.flushStart();
        LoggerFacade.log("str 2");
        LoggerFacade.flushStart();
        LoggerFacade.log(0);
        LoggerFacade.flushStart();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + lineSeparator() +
            "primitive: " + Integer.MAX_VALUE + lineSeparator() +
            "primitive: " + Integer.MAX_VALUE + lineSeparator() +
            "primitive: 7" + lineSeparator() +
            "string: str 2" + lineSeparator() +
            "primitive: 0" + lineSeparator()
        );
        //endregion
    }



    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws LoggerControllerException {
        //region when
        LoggerFacade.log("str 1");
        LoggerFacade.flushStart();
        LoggerFacade.log((byte)10);
        LoggerFacade.log(Byte.MAX_VALUE);
        LoggerFacade.flushStart();
        LoggerFacade.log("str 2");
        LoggerFacade.flushStart();
        LoggerFacade.log(0);
        LoggerFacade.flushStart();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + lineSeparator() +
            "primitive: " + Byte.MAX_VALUE + lineSeparator() +
            "primitive: 10" + lineSeparator() +
            "string: str 2" + lineSeparator() +
            "primitive: 0" + lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws LoggerControllerException {
        //region when
        LoggerFacade.log("str 1");
        LoggerFacade.log("str 2");
        LoggerFacade.log("str 2");
        LoggerFacade.flushStart();
        LoggerFacade.log(0);
        LoggerFacade.flushStart();
        LoggerFacade.log("str 2");
        LoggerFacade.log("str 3");
        LoggerFacade.log("str 3");
        LoggerFacade.log("str 3");
        LoggerFacade.flushStart();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + lineSeparator() +
            "string: str 2 (x2)" + lineSeparator() +
            "primitive: 0" + lineSeparator() +
            "string: str 2" + lineSeparator() +
            "string: str 3 (x3)" + lineSeparator()
        );
        //endregion
    }
}