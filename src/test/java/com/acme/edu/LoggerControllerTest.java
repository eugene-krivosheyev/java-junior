package com.acme.edu;

import com.acme.edu.exception.LoggerControllerException;
import com.acme.edu.message.AbstractMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.LogSaver;
import com.acme.edu.saver.Saver;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoggerControllerTest implements SysoutCaptureAndAssertionAbility {

    private LoggerController sut;
    private Saver saverMock;

    @Before
    public void setUp() {
        resetOut();
        captureSysout();
        saverMock = mock(LogSaver.class);
        sut = new LoggerController(saverMock);
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldCallSaveWhenFlushCalled() throws LoggerControllerException {
        AbstractMessage messageMock = mock(AbstractMessage.class);

        sut.log(messageMock);
        sut.flushStart();

        verify(saverMock).save(messageMock);
    }

    @Test
    public void shouldNotCallSaveWhenSameTypeLogged() throws LoggerControllerException {
        IntMessage intMock = spy(new IntMessage(0));

        sut.log(intMock);
        sut.log(intMock);
        sut.flushStart();

        verify(saverMock, times(1)).save(any());
    }

    @Test
    public void shouldCallSaveWhenDifferentTypeLogged() throws LoggerControllerException {
        IntMessage intMock = mock(IntMessage.class);
        StringMessage strMock = spy(new StringMessage(" "));

        sut.log(intMock);
        sut.log(strMock);
        sut.flushStart();

        verify(intMock).isSameType(strMock);
        verify(saverMock, times(2)).save(any());
    }

    @Test(expected = LoggerControllerException.class)
    public void shouldThrowExceptionWhenListOfLogIsEmpty() throws LoggerControllerException {
        sut.flushStart();
    }



}
