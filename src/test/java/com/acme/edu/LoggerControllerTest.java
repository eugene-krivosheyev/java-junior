package com.acme.edu;

import com.acme.edu.message.AbstractMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.LogSaver;
import com.acme.edu.saver.Saver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoggerControllerTest implements SysoutCaptureAndAssertionAbility {

    private LoggerController sut;

    @Before
    public void setUp() {
        resetOut();
        captureSysout();
        sut = new LoggerController(new LogSaver());
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

    @Test //возможно теперь он лишний, если оставить два нижних, нужно решить
    public void shouldCallSaveWhenFlushCalled() {
        AbstractMessage messageMock = mock(AbstractMessage.class);
        Saver saverMock = mock(LogSaver.class);

        sut = new LoggerController(saverMock);
        sut.log(messageMock);
        sut.flushStart();

        verify(saverMock).save(messageMock);
    }

    @Test
    public void shouldNotCallFlushWhenSameTypeLogged(){
        Saver saverMock = mock(LogSaver.class);
        sut = new LoggerController(saverMock);

        sut.log(new IntMessage(1));
        sut.log(new IntMessage(1));

        // calling flush is equal to calling method save
        verify(saverMock, times(0)).save(any());
    }

    @Test
    public void shouldCallFlushWhenDifferentTypeLogged(){
        Saver saverMock = mock(LogSaver.class);
        sut = new LoggerController(saverMock);

        sut.log(new IntMessage(1));
        sut.log(new StringMessage(""));
        sut.flushStart();

        // calling flush is equal to calling method save
        verify(saverMock, times(2)).save(any());
    }


}
