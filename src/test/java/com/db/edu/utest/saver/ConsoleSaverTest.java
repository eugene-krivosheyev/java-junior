package com.db.edu.utest.saver;

import com.db.edu.SysoutCaptureAndAssertionAbility;
import com.db.edu.saver.ConsoleSaver;
import com.db.edu.saver.Saver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleSaverTest implements SysoutCaptureAndAssertionAbility {

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
    void saveToConsole() {
        Saver saver = new ConsoleSaver();
        saver.save("message");
        assertSysoutContains("message");
    }
}