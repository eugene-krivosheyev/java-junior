package com.acme.edu.iteration01;

import com.acme.edu.LogOperationException;
import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut()  {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogInteger() throws LogOperationException {
        //region when
        Logger.log(1);
        Logger.log(0);
        Logger.log(-1);
        Logger.close();
        //endregion

        //region then
        assertSysoutContains("primitive: 1\n");
        assertSysoutContains("primitive: 0\n");
        assertSysoutContains("primitive: -1\n");
        //endregion
    }

    @Test
    public void shouldLogByte() throws LogOperationException {
        //region when
        Logger.log((byte)1);
        Logger.log((byte)0);
        Logger.log((byte)-1);
        Logger.close();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }


   // TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogChar() throws LogOperationException {
        //region when
        Logger.log('a');
        Logger.log('b');
        Logger.close();
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws LogOperationException {
        //region when
        Logger.log("test string 1");
        Logger.log("other str");
        Logger.close();
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws LogOperationException {
        //region when
        Logger.log(true);
        Logger.log(false);
        Logger.close();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws LogOperationException {
        //region when
        Logger.log(new Object());
        Logger.close();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }


}