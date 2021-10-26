package demo.ooad;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
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

//        Message messageStub = MessageStubBuilder.withBody(null).withIsSameType(false).build();

        final LoggerController controllerSut = new LoggerController(saverStub, filterDummy);
        controllerSut.log(defaultStateStub);
        controllerSut.log(differentTypeMessageStub);

        verify(saverStub).save("current state body");
    }

    @Test
    public void shouldNotLogWhenNullMessage() {
        final Filter filterDummy = mock(Filter.class);
        final Saver saverDummy = mock(Saver.class);
        final LoggerController controller = new LoggerController(saverDummy, filterDummy);

        final IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> controller.log(null)
        );
        assertThat(thrown).hasMessage("null message!!!");
    }
}
