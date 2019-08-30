package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.exceptions.LogOperationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
//    @Before
//    public void setUpSystemOut() throws IOException {
//        resetOut();
//        captureSysout();
//    }
//
//    @After
//    public void tearDown() {
//        resetOut();
//    }
//    //endregion
//
//    @Test
//    public void shouldLogInteger() throws IOException, LogOperationException {
//        //region when
//        Logger.log(1);
//        Logger.close();
//        Logger.log(0);
//        Logger.close();
//        Logger.log(-1);
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutContains("primitive: ");
//        assertSysoutEquals("primitive: 1" + System.lineSeparator() + "primitive: 0" + System.lineSeparator() +
//                "primitive: -1" + System.lineSeparator());
//        //endregion
//    }
//
//    @Test
//    public void shouldLogByte() throws IOException, LogOperationException {
//        //region when
//        Logger.log((byte) 1);
//        Logger.log((byte) 0);
//        Logger.log((byte) -1);
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutContains("primitive: ");
//        assertSysoutContains("1");
//        assertSysoutContains("0");
//        assertSysoutContains("-1");
//        //endregion
//    }
//
//
//    @Test
//    public void shouldLogChar() throws IOException, LogOperationException {
//        //region when
//        Logger.log('a');
//        Logger.log('b');
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutContains("char: ");
//        assertSysoutContains("a");
//        assertSysoutContains("b");
//        //endregion
//    }
//
//    @Test
//    public void shouldLogString() throws IOException, LogOperationException {
//        //region when
//        Logger.log("test string 1");
//        Logger.close();
//        Logger.log("other str");
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutContains("string: ");
//        assertSysoutContains("test string 1");
//        assertSysoutContains("other str");
//        //endregion
//    }
//
//    @Test
//    public void shouldLogBoolean() throws IOException, LogOperationException {
//        //region when
//        Logger.log(true);
//        Logger.log(false);
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutContains("primitive: ");
//        assertSysoutContains("true");
//        assertSysoutContains("false");
//        //endregion
//    }
//
//    @Test
//    public void shouldLogReference() throws IOException, LogOperationException {
//        //region when
//        Logger.log(new Object());
//        Logger.close();
//        //endregion
//
//        //region then
//        assertSysoutContains("reference: ");
//        assertSysoutContains("@");
//        //endregion
//    }
}