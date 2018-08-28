package com.acme.edu.logger;

import com.acme.edu.saver.SimpleSaver;
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


    @Test
    public void shouldDoNothingWhenMessageIsNull() {

        SimpleSaver testSaver = new SimpleSaver();
        testSaver.save(null);
        assertSysoutEquals("");
    }

    @Test
    public void shouldPrintProvidedMessageWhenItIsNotNull() {

        SimpleSaver testSaver = new SimpleSaver();
        testSaver.save("Test message string");
        assertSysoutEquals("Test message string" + System.lineSeparator());
    }
}