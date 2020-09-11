package com.acme.edu.iteration01;

import com.acme.edu.LoggerFacade;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.exception.LoggerControllerException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class LoggerFacadeTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogInteger() throws LoggerControllerException {
        //region when
        LoggerFacade.log(1);
        LoggerFacade.flushStart();
        LoggerFacade.log(0);
        LoggerFacade.flushStart();
        LoggerFacade.log(-1);
        LoggerFacade.flushStart();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1" + System.lineSeparator() +
                "primitive: 0" + System.lineSeparator() +
                "primitive: -1" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogByte() throws LoggerControllerException {
        //region when
        LoggerFacade.log(1);
        LoggerFacade.flushStart();
        LoggerFacade.log(0);
        LoggerFacade.flushStart();
        LoggerFacade.log(-1);
        LoggerFacade.flushStart();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

    @Test
    public void shouldLogChar() throws LoggerControllerException {
        //region when
        LoggerFacade.log('a');
        LoggerFacade.flushStart();
        LoggerFacade.log('b');
        LoggerFacade.flushStart();
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws LoggerControllerException {
        //region when
        LoggerFacade.log("test string 1");
        LoggerFacade.flushStart();
        LoggerFacade.log("other str");
        LoggerFacade.flushStart();
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws LoggerControllerException {
        //region when
        LoggerFacade.log(true);
        LoggerFacade.flushStart();
        LoggerFacade.log(false);
        LoggerFacade.flushStart();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }



    @Test
    public void shouldLogReference() throws LoggerControllerException {
        //region when
        LoggerFacade.log(new Object());
        LoggerFacade.flushStart();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }
}