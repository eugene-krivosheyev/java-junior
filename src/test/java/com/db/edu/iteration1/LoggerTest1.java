package com.db.edu.iteration1;

import com.db.edu.Logger;
import com.db.edu.LoggerController;
import com.db.edu.Prefix;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.*;

import java.io.*;

public class LoggerTest1 implements SysoutCaptureAndAssertionAbility {
    //region given
    @BeforeEach
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogInteger() throws IOException {
        //region when
        Logger.log(1);
        LoggerController.close();
        Logger.log(0);
        LoggerController.close();
        Logger.log(-1);
        LoggerController.close();
        //endregion

        //region then
        assertSysoutContains(Prefix.PRIMITIVE.value);
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Logger.log((byte) 1);
        Logger.log((byte) 0);
        Logger.log((byte) -1);
        //endregion

        //region then
        assertSysoutContains(Prefix.PRIMITIVE.value);
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
        Logger.log('b');
        //endregion
        //region then
        assertSysoutContains(Prefix.CHAR.value);
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        Logger.log("test string 1");
        Logger.log("other str");
        LoggerController.close();
        //endregion
        //region then
        assertSysoutContains(Prefix.STRING.value);
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
        assertSysoutContains(Prefix.PRIMITIVE.value);
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
        assertSysoutContains(Prefix.REFERENCE.value);
        assertSysoutContains("@");
        //endregion
    }
}