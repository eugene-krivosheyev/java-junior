package com.db.edu.iteration1;

import com.db.edu.Logger;
import com.db.edu.LoggerController;
import com.db.edu.Prefix;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.*;

import java.io.*;

public class Logger1Test implements SysoutCaptureAndAssertionAbility {
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
    @Disabled
    public void shouldLogInteger() throws IOException {
        //region when
        Logger.log(1);
        Logger.loggerController.close();
        Logger.log(0);
        Logger.loggerController.close();
        Logger.log(-1);
        Logger.loggerController.close();
        //endregion

        //region then
        assertSysoutContains(Prefix.PRIMITIVE.value);
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

    @Test
    @Disabled
    public void shouldLogByte() throws IOException {
        //region when
        Logger.log((byte) 1);
        Logger.loggerController.close();
        Logger.log((byte) 0);
        Logger.loggerController.close();
        Logger.log((byte) -1);
        Logger.loggerController.close();
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
    @Disabled
    public void shouldLogChar() throws IOException {
        //region when
        Logger.log('a');
        Logger.loggerController.close();
        Logger.log('b');
        Logger.loggerController.close();
        //endregion
        //region then
        assertSysoutContains(Prefix.CHAR.value);
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    @Disabled
    public void shouldLogString() throws IOException {
        //region when
        Logger.log("test string 1");
        Logger.log("other str");
        Logger.loggerController.close();
        //endregion
        //region then
        assertSysoutContains(Prefix.STRING.value);
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    @Disabled
    public void shouldLogBoolean() throws IOException {
        //region when
        Logger.log(true);
        Logger.loggerController.close();
        Logger.log(false);
        Logger.loggerController.close();
        //endregion
        //region then
        assertSysoutContains(Prefix.PRIMITIVE.value);
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    @Disabled
    public void shouldLogReference() throws IOException {
        //region when
        Logger.log(new Object());
        Logger.loggerController.close();
        //endregion
        //region then
        assertSysoutContains(Prefix.REFERENCE.value);
        assertSysoutContains("@");
        //endregion
    }
}