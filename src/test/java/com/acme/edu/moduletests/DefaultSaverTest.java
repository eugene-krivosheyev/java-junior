package com.acme.edu.moduletests;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.saver.DefaultSaver;
import com.acme.edu.saver.Saver;
import com.acme.edu.saver.SavingException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

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

    @Test(expected = SavingException.class)
    public void shouldThrowExceptionWithErrorCodeWhenArgumentIsNull() throws IOException, SavingException {
        try {
            saver.save(null);
        } catch (SavingException e) {
            assertEquals(1, e.getExceptionCode());
            throw e;
        }

        assertSysoutEquals("");
    }

    @Test
    public void shouldSaveStringWithoutException() throws IOException, SavingException {
        String outputString = "Hello";
        saver.save(outputString);

        assertSysoutEquals(outputString + System.lineSeparator());
    }
}
