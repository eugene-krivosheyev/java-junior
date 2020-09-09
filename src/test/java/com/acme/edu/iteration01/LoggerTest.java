package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
        Logger.clearLogger();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    @Ignore
    public void shouldLogInteger() throws IOException {
        //region when
        Logger.log(1);
        Logger.postProcessing();
        Logger.log(0);
        Logger.postProcessing();
        Logger.log(-1);
        Logger.postProcessing();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1" + System.lineSeparator() + "primitive: 0" + System.lineSeparator() + "primitive: -1" + System.lineSeparator());
        //endregion
    }

    @Test
    @Ignore
    public void shouldLogByte() throws IOException {
        //region when
        Logger.log((byte)1);
        Logger.postProcessing();
        Logger.log((byte)0);
        Logger.postProcessing();
        Logger.log((byte)-1);
        Logger.postProcessing();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

    @Test
    @Ignore
    public void shouldLogChar() throws IOException {
        //region when
        Logger.log('a');
        Logger.postProcessing();
        Logger.log('b');
        Logger.postProcessing();
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }


    @Test
    @Ignore
    public void shouldLogString() throws IOException {
        //region when
        Logger.log("test string 1");
        Logger.postProcessing();
        Logger.log("other str");
        Logger.postProcessing();
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }


    @Test
    @Ignore
    public void shouldLogBoolean() throws IOException {
        //region when
        Logger.log(true);
        Logger.postProcessing();
        Logger.log(false);
        Logger.postProcessing();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }


    @Test
    @Ignore
    public void shouldLogReference() throws IOException {
        //region when
        Logger.log(new Object());
        Logger.postProcessing();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }

}