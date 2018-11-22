package com.acme.edu.iteration01;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.TypeSafeLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;

//ATDD
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
//        region when
        //System.out.println("!!!");
        TypeSafeLogger.log(1);
        TypeSafeLogger.flush();
        TypeSafeLogger.log(0);
        TypeSafeLogger.flush();
        TypeSafeLogger.log(-1);
        TypeSafeLogger.flush();
        //endregion
        //i18n, l16n
        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1" + lineSeparator() + "primitive: 0" + lineSeparator() + "primitive: -1" + lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        TypeSafeLogger.log((byte)1);
        TypeSafeLogger.flush();
        TypeSafeLogger.log((byte)0);
        TypeSafeLogger.flush();
        TypeSafeLogger.log((byte)-1);
        TypeSafeLogger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

//    TODO: implement TypeSafeLogger solution to match specification as tests

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        TypeSafeLogger.log('a');
        TypeSafeLogger.flush();
        TypeSafeLogger.log('b');
        TypeSafeLogger.flush();
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
        TypeSafeLogger.log("test string 1");
        TypeSafeLogger.flush();
        TypeSafeLogger.log("other str");
        TypeSafeLogger.flush();
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
        TypeSafeLogger.log(true);
        TypeSafeLogger.flush();
        TypeSafeLogger.log(false);
        TypeSafeLogger.flush();
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
        TypeSafeLogger.log(new Object());
        TypeSafeLogger.flush();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }


}
