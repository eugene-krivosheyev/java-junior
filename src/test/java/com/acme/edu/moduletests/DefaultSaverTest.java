package com.acme.edu.moduletests;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.saver.DefaultSaver;
import com.acme.edu.saver.Saver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DefaultSaverTest implements SysoutCaptureAndAssertionAbility {
    private Saver saver;

    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
        saver = new DefaultSaver();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldNotSaveNull() throws IOException {
        saver.save(null);

        assertSysoutEquals("");
    }

    @Test
    public void shouldSaveString() throws IOException {
        String outputString = "Hello";
        saver.save(outputString);

        assertSysoutEquals(outputString + System.lineSeparator());
    }
}
