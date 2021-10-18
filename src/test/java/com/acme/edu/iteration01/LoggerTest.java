package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import static java.lang.System.lineSeparator;


public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    public static final String sep = lineSeparator();

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
        Logger.log(1);
        Logger.flash();
        Logger.log(0);
        Logger.flash();
        Logger.log(-1);
        Logger.flash();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1" + sep + "primitive: 0" + sep + "primitive: -1" + sep);
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Logger.log((byte) 1);
        Logger.flash();
        Logger.log((byte) 0);
        Logger.flash();
        Logger.log((byte) -1);
        Logger.flash();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }


    //TODO: implement Logger solution to match specification as tests


    @Test
    public void shouldLogChar() throws IOException {
        //region when
        Logger.log('a');
        Logger.flash();
        Logger.log('b');
        Logger.flash();
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
        Logger.log("test string 1");
        Logger.flash();
        Logger.log("other str");
        Logger.flash();
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
        Logger.log(true);
        Logger.flash();
        Logger.log(false);
        Logger.flash();
        //endregion

        //region then
        assertSysoutContains("boolean: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }
    @Test
    public void shouldLogReference() throws IOException {
        //region when
        Logger.log(new Object());
        Logger.flash();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }

}
