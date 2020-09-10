package refactoring;

import org.junit.Before;
import org.junit.Test;
import refactoring.message.IntMessage;
import refactoring.message.Message;
import refactoring.save.Saver;

import static org.mockito.Mockito.*;

public class LoggerControllerTests {
    private LoggerController sut;
    private Saver saverMock;

    @Before
    public void setUp() {
        saverMock = mock(Saver.class);
        sut = new LoggerController(saverMock);
    }

    @Test
    public void shouldSetUpStateWhenFirstMessage() {
        Message dummyMessage = mock(Message.class);
        Message messageDoubler = mock(Message.class);
        when(messageDoubler.isSameType(dummyMessage)).thenReturn(false);

        sut.log(messageDoubler);
        sut.log(dummyMessage);

        verify(saverMock).save(messageDoubler);
    }

    @Test
    public void shouldAccumulateWhenCurrentTypeMessageStateAndSameTypeMessageLogged() {
        Message firstMessageDoubler = mock(Message.class);
        Message secondMessageDoubler = spy(new IntMessage(0)); // mock(Message.class);
        when(firstMessageDoubler.isSameType(secondMessageDoubler)).thenReturn(true);

        sut.log(firstMessageDoubler); //set state -> int message
        sut.log(secondMessageDoubler);

        verify(firstMessageDoubler).reduce(secondMessageDoubler);
        verify(saverMock, never()).save(any(Message.class));
    }
}
