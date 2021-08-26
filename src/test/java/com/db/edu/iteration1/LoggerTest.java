package com.db.edu.iteration1;

import com.db.edu.Logger;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.*;

import static com.db.edu.Prefix.*;


public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    @BeforeEach
    public void setUpSystemOut() {
        resetOut();
        captureSysout();
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldLogInteger() {
        Logger.log(1);
        Logger.flush();
        Logger.log(0);
        Logger.flush();
        Logger.log(-1);
        Logger.flush();

        logAssert(PRIMITIVE_PREFIX.body, "1", "0", "-1");
    }

    @Test
    public void shouldLogByte() {
        Logger.log((byte)1);
        Logger.flush();
        Logger.log((byte)0);
        Logger.flush();
        Logger.log((byte)-1);
        Logger.flush();

        logAssert(PRIMITIVE_PREFIX.body, "1", "0", "-1");
    }

    @Test
    public void shouldLogChar() {
        Logger.log('a');
        Logger.flush();
        Logger.log('b');
        Logger.flush();

        logAssert(CHAR_PREFIX.body, "a", "b");
    }

    @Test
    public void shouldLogString() {
        Logger.log("test string 1");
        Logger.log("other str");
        Logger.flush();

        logAssert(STRING_PREFIX.body, "test string 1", "other str");
    }

    @Test
    public void shouldLogBoolean() {
        Logger.log(true);
        Logger.flush();
        Logger.log(false);
        Logger.flush();

        logAssert(PRIMITIVE_PREFIX.body, "true", "false");
    }

    @Test
    public void shouldLogReference() {
        Logger.log(new Object());
        Logger.flush();

        logAssert(OBJECT_PREFIX.body, "@");
    }
}