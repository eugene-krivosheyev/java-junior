package controller;

import accumulator.Accumulator;
import accumulator.FlushAccumulator;
import exeption.EmptyAccumulatorException;
import exeption.EmptyMessageException;
import message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import printer.ConsolePrinter;
import printer.Printer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ControllerTest {
    private Controller controller;
    private Accumulator accumulatorStub1;
    private Accumulator accumulatorStub2;
    private Printer printerMock;
    private Message messageStub;

    @BeforeEach
    void init() {
        messageStub = mock(Message.class);
        accumulatorStub1 = mock(FlushAccumulator.class);
        accumulatorStub2 = mock(Accumulator.class);
        printerMock = mock(ConsolePrinter.class);
        controller = new Controller(accumulatorStub1, printerMock);
    }

    @Test
    void shouldLogAfterAccumulatorTypeSwitch() {

        final String testValue1 = "TestValue1";

        when(messageStub.getAccumulator()).thenReturn(accumulatorStub2);
        when(accumulatorStub2.isNewAccumulatorType(any())).thenReturn(true);
        when(accumulatorStub1.getBody()).thenReturn(testValue1);
        when(accumulatorStub2.extractUnpromtLines()).thenReturn(null);

        controller.log(messageStub);

        verify(printerMock).print(testValue1);
    }

    @Test
    void shouldNotLogWithNoAccumulatorTypeSwitch() {

        when(messageStub.getAccumulator()).thenReturn(accumulatorStub2);
        when(accumulatorStub2.isNewAccumulatorType(any())).thenReturn(false);
        when(accumulatorStub1.extractUnpromtLines()).thenReturn(null);

        controller.log(messageStub);

        verify(printerMock, never()).print(any());
    }

    @Test
    void shouldLogAfterAccumulatingUnpromtLines() {

        final String[] testValue2 = {"TestValue2"};

        when(messageStub.getAccumulator()).thenReturn(accumulatorStub2);
        when(accumulatorStub2.isNewAccumulatorType(any())).thenReturn(false);
        when(accumulatorStub1.extractUnpromtLines()).thenReturn(testValue2);

        controller.log(messageStub);

        verify(printerMock).print(testValue2[0]);
    }

    @Test
    void shouldThrowEmptyMessageException() {
        final EmptyMessageException thrown = assertThrows(
                EmptyMessageException.class,
                () -> controller.log(null)
        );
        assertThat(thrown).hasMessage("Attempt to log empty message");
    }

    @Test
    void shouldThrowEmptyAccumulatorException() {
        when(messageStub.getAccumulator()).thenReturn(null);
        final EmptyAccumulatorException thrown = assertThrows(
                EmptyAccumulatorException.class,
                () -> controller.log(messageStub)
        );
        assertThat(thrown).hasMessage("Attempt to log message with no accumulator");
    }
}
