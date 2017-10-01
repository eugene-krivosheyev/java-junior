package com.acme.edu.iteration01;

import com.acme.edu.logger.LoggerCore;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class LoggerCoreTest implements SysoutCaptureAndAssertionAbility {
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
    public void shouldLogInteger() throws IOException {
        //region when
        LoggerCore.log(1);
        LoggerCore.log(0); // 0
        LoggerCore.log(-1); // -1
        LoggerCore.stop();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1\nprimitive: 0\nprimitive: -1\n");
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        LoggerCore.log((byte)1);
        LoggerCore.log((byte)0);
        LoggerCore.log((byte)-1);
        LoggerCore.stop();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }


    // TODO: implement LoggerCore solution to match specification as tests

    @Test

    public void shouldLogChar() throws IOException {
        //region when
        LoggerCore.log('a');
        LoggerCore.log('b');
        LoggerCore.stop();
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        LoggerCore.log("test string 1");
        LoggerCore.log("other str");
        LoggerCore.stop();
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        LoggerCore.log(true);
        LoggerCore.log(false);
        LoggerCore.stop();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        LoggerCore.log(new Object());
        LoggerCore.stop();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }
}
