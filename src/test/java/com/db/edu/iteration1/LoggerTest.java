package com.db.edu.iteration1;

import com.db.edu.Logger;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static com.db.edu.Logger.REFERENCE_PREFIX;
import static com.db.edu.Logger.PRIMITIVE_PREFIX;
import static com.db.edu.Logger.CHAR_PREFIX;
import static com.db.edu.Logger.STRING_PREFIX;
import static java.lang.System.lineSeparator;



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
        Logger.flush();
        Logger.log(0);
        Logger.flush();
        Logger.log(-1);
        Logger.flush();
        //endregion

        //region then
        assertLogEquals(PRIMITIVE_PREFIX, "1", "0", "-1");
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Logger.log((byte)1);
        Logger.flush();
        Logger.log((byte)0);
        Logger.flush();
        Logger.log((byte)-1);
        Logger.flush();
        //endregion

        //region then
        assertLogContains(PRIMITIVE_PREFIX, "1", "0", "-1");
        //endregion
    }

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        Logger.log('a');
        Logger.flush();
        Logger.log('b');
        Logger.flush();
        //endregion

        //region then
        assertLogContains(CHAR_PREFIX, "a", "b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        Logger.log("test string 1");
        Logger.flush();
        Logger.log("other string");
        Logger.flush();
        //endregion

        //region then
        assertLogContains(STRING_PREFIX, "test string 1", "other string");
        //endregion
    }
    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        Logger.log(true);
        Logger.flush();
        Logger.log(false);
        Logger.flush();
        //endregion

        //region then
        assertLogContains(PRIMITIVE_PREFIX, "true", "false");
        //endregion
    }
    @Test
    public void shouldLogReference() throws IOException {
        //region when
        Logger.log(new Object());
        //endregion

        //region then
        assertLogContains(REFERENCE_PREFIX, "@");
        //endregion
    }

    private void assertLogContains(String... asserts) {
        for (String current : asserts) {
            assertSysoutContains(current);
        }
    }

    private void assertLogEquals(String prefix, String... asserts) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String current : asserts) {
            stringBuilder.append(prefix).append(current).append(lineSeparator());
        }
        assertSysoutEquals(stringBuilder.toString());
    }
}