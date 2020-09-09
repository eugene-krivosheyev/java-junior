package com.acme.edu.iteration05;

import com.acme.edu.LoggerController;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.message.AbstractMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.saver.LogSaver;
import com.acme.edu.saver.Saver;
import demo.ooad.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoggerFacadeTests implements SysoutCaptureAndAssertionAbility {

    private LoggerController sut;

    @Before
    public void setUp() {
        resetOut();
        captureSysout();
        Saver saver = new LogSaver();
        sut = new LoggerController(saver);
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldSaveMessageWhenFlushCalled() {
        AbstractMessage mock = mock(AbstractMessage.class);
        when(mock.getPreparedMessage()).thenReturn("hahaha");
        sut.log(mock);
        sut.flushStart();
        assertSysoutContains("hahaha");
    }

}
