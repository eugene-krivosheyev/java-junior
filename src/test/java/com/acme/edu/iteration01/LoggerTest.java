package com.acme.edu.iteration01;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.logger2.Logger2;
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
//        Logger.start();
//        Logger.log(1);
//        Logger.log(0); // 0
//        Logger.log(-1); // -1
//        Logger.stop();
//        Logger.out();
        //endregion

        // region when
        Logger2.log(1);
        Logger2.log(0); // 0
        Logger2.log(-1); // -1
        Logger2.stop();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1\nprimitive: 0\nprimitive: -1\n");
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {

        //region when
//        Logger.start();
//        Logger.log((byte)1);
//        Logger.log((byte)0);
//        Logger.log((byte)-1);
//        Logger.stop();
//        Logger.out();
        //endregion

        //region when
        Logger2.log((byte)1);
        Logger2.log((byte)0);
        Logger2.log((byte)-1);
        Logger2.stop();
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

    public void shouldLogChar() throws IOException {
        //region when
//        Logger.start();
//        Logger.log('a');
//        Logger.log('b');
//        Logger.stop();
//        Logger.out();
        //endregion

        //region when
        Logger2.log('a');
        Logger2.log('b');
        Logger2.stop();
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
//        Logger.start();
//        Logger.log("test string 1");
//        Logger.log("other str");
//        Logger.stop();
//        Logger.out();
        //endregion

        //region when
        Logger2.log("test string 1");
        Logger2.log("other str");
        Logger2.stop();
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
//        Logger.start();
//        Logger.log(true);
//        Logger.log(false);
//        Logger.stop();
//        Logger.out();
        //endregion

        //region when
        Logger2.log(true);
        Logger2.log(false);
        Logger2.stop();
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
//        Logger.start();
//        Logger.log(new Object());
//        Logger.stop();
//        Logger.out();
        //endregion

        //region when
        Logger2.log(new Object());
        Logger2.stop();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }
}
