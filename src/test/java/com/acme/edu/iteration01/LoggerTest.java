package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static com.acme.edu.Logger.*;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    private static String type;

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
        type = typePrimitive;
        //region when
        Logger.logWithFlush(1, 0, -1);
        //endregion

        //region then
        checkLog("1", "0", "-1");
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        type = typePrimitive;
        //region when
        Logger.logWithFlush((byte)1, (byte)0, (byte)-1);
        //endregion

        //region then
        checkLog("1", "0", "-1");
        //endregion
    }

    @Test
    public void shouldLogChar() throws IOException {
        type = typeChar;
        //region when
        Logger.logWithFlush('a', 'b');
        //endregion

        //region then
        checkLog("a", "b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        type = typeString;
        String str1 = "first string";
        String str2 = "second string";
        //region when
        Logger.logWithFlush(str1, str2);
        //endregion

        //region then
        checkLog(str1, str2);
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        type = typePrimitive;
        //region when
        Logger.logWithFlush(true, false);
        //endregion

        //region then
        checkLog("true", "false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        type = typeReference;
        //region when
        Logger.logWithFlush(new Object());
        //endregion

        //region then
        assertSysoutContains(type);
        assertSysoutContains("@");
        //endregion
    }

    private void checkLog(String... valuesToCheck) throws IOException {
        for (String valueToCheck : valuesToCheck) {
            assertSysoutContains(type + valueToCheck);
        }
    }
}