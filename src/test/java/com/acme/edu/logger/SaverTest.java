package com.acme.edu.logger;

import com.acme.edu.saver.SaveException;
import com.acme.edu.saver.ConsoleSaver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.acme.edu.SysoutCaptureAndAssertionAbility;

import java.io.IOException;

/**
 * Created by Java_1 on 28.08.2018.
 */
public class SaverTest implements SysoutCaptureAndAssertionAbility {

    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test(expected = SaveException.class)
    public void shouldDoNothingWhenMessageIsNull() throws SaveException{
        ConsoleSaver testSaver = new ConsoleSaver();
        testSaver.save(null);
        assertSysoutEquals("");
    }

    @Test
    public void shouldPrintProvidedMessageWhenItIsNotNull() throws SaveException{
        ConsoleSaver testSaver = new ConsoleSaver();
        testSaver.save("Test message string");
        assertSysoutEquals("Test message string" + System.lineSeparator());
    }
}