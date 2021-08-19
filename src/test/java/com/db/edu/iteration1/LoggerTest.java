package com.db.edu.iteration1;

import com.db.edu.Logger;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.*;


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

    private void logAssert(String ... args) {
        for (String arg : args) {
            assertSysoutContains(arg);
        }
    }

    @Test
    public void shouldLogInteger() {
        Logger.log(1);
        Logger.log(0);
        Logger.log(-1);

        logAssert("primitive: ", "1", "0", "-1");
    }

    @Test
    public void shouldLogByte() {
        Logger.log((byte)1);
        Logger.log((byte)0);
        Logger.log((byte)-1);

        logAssert("primitive: ", "1", "0", "-1");
    }

    @Test
    public void shouldLogChar() {
        Logger.log('a');
        Logger.log('b');

        logAssert("char: ", "a", "b");
    }

    @Test
    public void shouldLogString() {
        Logger.log("test string 1");
        Logger.log("other str");

        logAssert("string: ", "test string 1", "other str");
    }

    @Test
    public void shouldLogBoolean() {
        Logger.log(true);
        Logger.log(false);

        logAssert("primitive: ", "true", "false");
    }

    @Test
    public void shouldLogReference() {
        Logger.log(new Object());

        logAssert("reference: ", "@");
    }
}