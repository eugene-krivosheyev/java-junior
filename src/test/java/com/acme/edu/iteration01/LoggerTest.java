package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
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
        Logger.log(0);
        Logger.log(-1);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1\nprimitive: 0\nprimitive: -1\n");
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Logger.log("ggg");

        Logger.log((byte)0);
        Logger.log((byte)-1);

        assertSysoutEquals(
        "primitive: 0\nprimitive: 1\nprimitive: -1"
        );
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
//        assertSysoutContains("0");
//        assertSysoutContains("-1");

        //endregion
    }

//    TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        Logger.log('a');
        Logger.log('b');
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }
    /*

    @Test
    public void shouldLogString() throws IOException {
        //region when
        Logger.log("test string 1");
        Logger.log("other str");
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
        Logger.log(false);
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
        Logger.log(new Object());
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }

    */
}