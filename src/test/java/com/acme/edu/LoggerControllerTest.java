package com.acme.edu;

import com.acme.edu.exception.FlushLogException;
import com.acme.edu.exception.LoggerException;
import com.acme.edu.message.AbstractMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.Saver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class LoggerControllerTest implements SysoutCaptureAndAssertionAbility {
    private LoggerController sut;
    private Saver saverMock;

    @Before
    public void setUp() {
        resetOut();
        captureSysout();
        saverMock = mock(ConsoleSaver.class);
        sut = new LoggerController(saverMock);
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldCallSaveWhenFlushCalled() throws LoggerException {
        AbstractMessage messageMock = mock(AbstractMessage.class);

        sut.log(messageMock);
        sut.end();

        verify(saverMock).save(messageMock);
    }

    @Test
    public void shouldNotCallSaveWhenSameTypeLogged() throws LoggerException {
        IntMessage intMock = spy(new IntMessage(0));

        sut.log(intMock);
        sut.log(intMock);
        sut.end();

        verify(saverMock).save(any(IntMessage.class));
    }

    @Test
    public void shouldCallSaveWhenDifferentTypeLogged() throws LoggerException {
        IntMessage intMock = mock(IntMessage.class);
        StringMessage strMock = spy(new StringMessage(" "));

        sut.log(intMock);
        sut.log(strMock);
        sut.end();

        verify(intMock).isSameType(strMock);
        verify(saverMock, times(2)).save(any());
    }

    @Test
    public void shouldCallPrepareMessageWhenFlushStarted() throws LoggerException {
        IntMessage mock = spy(new IntMessage(1));

        sut.log(mock);
        sut.log(mock);
        sut.log(mock);
        sut.log(mock);
        sut.end();

        verify(mock).prepareMessage(any(ArrayList.class));
    }

    @Test(expected = FlushLogException.class)
    public void shouldThrowExceptionWhenListOfLogIsEmpty() throws LoggerException {
        sut.flush();
    }
}
