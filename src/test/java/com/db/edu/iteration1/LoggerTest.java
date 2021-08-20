package com.db.edu.iteration1;

import com.db.edu.Logger;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.*;

import java.io.*;

import static com.db.edu.Logger.PRIMITIVE_PREFIX;
import static com.db.edu.Logger.CHAR_PREFIX;
import static com.db.edu.Logger.STRING_PREFIX;
import static com.db.edu.Logger.REFERENCE_PREFIX;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
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
        Logger.close();
        Logger.log(0);
        Logger.close();
        Logger.log(-1);
        Logger.close();
        //endregion

        //region then
        assertSysoutContains(PRIMITIVE_PREFIX);
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
        assertSysoutContains(PRIMITIVE_PREFIX);
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
        assertSysoutContains(CHAR_PREFIX);
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        Logger.log("test string 1");
        Logger.log("other str");
        Logger.close();
        //endregion
        //region then
        assertSysoutContains(STRING_PREFIX);
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
        assertSysoutContains(PRIMITIVE_PREFIX);
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
        assertSysoutContains(REFERENCE_PREFIX);
        assertSysoutContains("@");
        //endregion
    }
}