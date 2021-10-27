package com.acme.edu;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;
import com.acme.edu.messages.IntMessage;
import com.acme.edu.messages.StringMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class LoggerControllerTest {
    private Printer printer;
    private LoggerController controllerSut;
    private Message stringMessage;
    private Message intMessage;
    private StringMessage sameTypeMessage;
    private StringMessage anotherStringMessage;

    @BeforeEach
    public void TestsPreparation(){
        printer = mock(Printer.class);
        controllerSut = new LoggerController(printer);
        stringMessage = mock(StringMessage.class);
        intMessage = mock(IntMessage.class);
        sameTypeMessage = mock(StringMessage.class);
        anotherStringMessage = mock(StringMessage.class);
    }

    @Test
    public void shouldFlushWhenLogDifferentTypeMessage() {

        when(stringMessage.isSameType(intMessage)).thenReturn(false);
        when(intMessage.isSameType(stringMessage)).thenReturn(false);

        when(stringMessage.getDecoratedString()).thenReturn("string: defaultexample");
        when(intMessage.getDecoratedString()).thenReturn("primitive: 12");

        controllerSut.log(stringMessage);
        controllerSut.log(intMessage);
        controllerSut.flush();

        InOrder inOrder = Mockito.inOrder(printer);
        inOrder.verify(printer).print(stringMessage);
        inOrder.verify(printer).print(intMessage);
    }
    @Test
    public void shouldAccumulateWhenLogSameTypeMessage() {

        when(stringMessage.isSameType(sameTypeMessage)).thenReturn(true);
        when(stringMessage.accumulate(sameTypeMessage)).thenReturn(null);

        controllerSut.log(stringMessage);
        controllerSut.log(sameTypeMessage);
        controllerSut.flush();

        verify(printer, times(1)).print(stringMessage);
        verifyNoMoreInteractions(printer);
    }

    @Test
    public void shouldNotAccumulateWhenLogDifferentMessages() {

        when(stringMessage.isSameType(anotherStringMessage)).thenReturn(true);
        when(stringMessage.accumulate(anotherStringMessage))
                .thenReturn(anotherStringMessage);

        controllerSut.log(stringMessage);
        controllerSut.log(anotherStringMessage);
        controllerSut.flush();

        verify(printer, times( 1)).print(stringMessage);
        verify(printer, times( 1)).print(anotherStringMessage);
    }
}
