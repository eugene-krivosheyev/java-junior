package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import static com.acme.edu.LoggerController.*;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.Type;
import org.junit.jupiter.api.*;

import java.io.*;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    static private final String sep = System.lineSeparator();
    private static final Logger logger = new Logger();

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
        logger.log(1);
        logger.flush();
        logger.log(0);
        logger.flush();
        logger.log(-1);
        logger.flush();
        //endregion

        //region then
        assertSysoutContains(Type.PRIMITIVE.value);
        assertSysoutEquals(Type.PRIMITIVE.value + "1" + sep + Type.PRIMITIVE.value + "0" + sep + Type.PRIMITIVE.value + "-1" + sep);
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        logger.log((byte)1);
        logger.log((byte)0);
        logger.log((byte)-1);
        //endregion

        //region then
        assertSysoutContains(Type.PRIMITIVE.value);
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }


    // TODO: implement logger solution to match specification as tests

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        logger.log('a');
        logger.log('b');
        //endregion

        //region then
        assertSysoutContains(Type.CHAR.value);
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        logger.log("test string 1");
        logger.log("other str");
        logger.flush();
        //endregion

        //region then
        assertSysoutContains(Type.STRING.value);
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        logger.log(true);
        logger.log(false);
        //endregion

        //region then
        assertSysoutContains(Type.PRIMITIVE.value);
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        logger.log(new Object());
        //endregion

        //region then
        assertSysoutContains(Type.REFERENCE.value);
        assertSysoutContains("@");
        //endregion
    }

}