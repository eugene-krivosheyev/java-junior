package demo.ooad;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {
    @Test
    public void shouldFlushWhenLogDifferentTypeMessage() {
        Filter filterDummy = mock(Filter.class);
        Saver saverStub = mock(Saver.class);
        Message defaultStateStub = mock(Message.class);
        Message differentTypeMessageStub = mock(Message.class);

        when(defaultStateStub.isSameType(differentTypeMessageStub)).thenReturn(false);
//        when(defaultStateStub.isSameType(any(Message.class))).thenReturn(false);
        when(defaultStateStub.getBody()).thenReturn("current state body");

        final LoggerController controllerSut = new LoggerController(saverStub, filterDummy);
        controllerSut.log(defaultStateStub);
        controllerSut.log(differentTypeMessageStub);

        verify(saverStub).save("current state body");
    }
}
