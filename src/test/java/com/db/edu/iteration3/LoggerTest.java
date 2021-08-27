package com.db.edu.iteration3;

import com.db.edu.Logger;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.db.edu.message.Prefix.PRIMITIVE_PREFIX;
import static com.db.edu.message.Prefix.STRING_PREFIX;

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
    public void shouldLogStringsWithOneMethodCall() {
        Logger.log("str1", "string 2", "str 3");

        logAssert(STRING_PREFIX.body, "str1", "string 2", "str 3");
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() {
        Logger.log(-1, 0, 1, 3);

        logAssert(PRIMITIVE_PREFIX.body, "3");
    }
}
