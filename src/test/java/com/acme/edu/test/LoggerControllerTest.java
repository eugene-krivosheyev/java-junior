package com.acme.edu.test;

import com.acme.edu.LoggerController;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.message.IntMessage;
import com.acme.edu.saver.ConsoleLoggerSaver;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class LoggerControllerTest implements SysoutCaptureAndAssertionAbility {
    private LoggerController sut;

    @Before
    public void setUp() {
        ConsoleLoggerSaver mockSaver = mock(ConsoleLoggerSaver.class);
        sut = new LoggerController(mockSaver);
    }

    @Ignore
    @Test
    public void messageIsPrintedWhenFlush() {
        IntMessage mockInt = mock(IntMessage.class);
        sut.setCurrentMessage(mockInt);


        sut.flush();

        assertSysoutEquals("");
        //assertThat();
    }

}
