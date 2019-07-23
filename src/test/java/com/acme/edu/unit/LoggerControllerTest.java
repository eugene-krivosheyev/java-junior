package com.acme.edu.unit;

import com.acme.edu.LoggerController;
import com.acme.edu.command.CommandMessage;
import com.acme.edu.command.CommandMessageInt;
import com.acme.edu.command.CommandMessageString;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.Saver;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoggerControllerTest {

    /*@Test
    public void shouldUpdateWhenPreviousCommandNotNull() {
        Saver saverStub = mock(Saver.class);
        CommandMessage commandMessageStub = mock(CommandMessage.class);
        LoggerController loggerSut = new LoggerController(saverStub);

        org.junit.Assert.assertTrue();
    }*/

    @Test
    public  void  shouldPrimitiveDecorationBeCorrectWhenPrimitive(){
        ConsoleSaver stub = mock(ConsoleSaver.class);
        LoggerController sut = new LoggerController(stub);
        CommandMessageInt stubInt = mock(CommandMessageInt.class);
        when(stubInt.primitiveDecorator()).thenReturn("primitive: ");

        sut.setLogCounter(1);
        sut.setPreviousCommand(stubInt);
        sut.flush();

        verify(stub).save("primitive: ");
        verify(stubInt).flush(stub);
    }

    @Test
    public  void  shouldPrimitiveDecorationBeCorrectWhenNotPrimitive(){
        ConsoleSaver stub = mock(ConsoleSaver.class);
        LoggerController sut = new LoggerController(stub);
        CommandMessageInt stubInt = mock(CommandMessageInt.class);
        when(stubInt.primitiveDecorator()).thenReturn("");

        sut.setLogCounter(5);
        sut.setPreviousCommand(stubInt);
        sut.flush();

        verify(stub).save("");
        verify(stubInt).flush(stub);
    }

    @Test
    public void shouldUpdateWhenPreviousCommandNotNull() {
        Saver stub = mock(Saver.class);
        LoggerController sut = new LoggerController(stub);
        CommandMessage dummy = mock(CommandMessage.class);
        CommandMessage dummy1 = mock(CommandMessage.class);

        sut.setPreviousCommand(dummy1);

        sut.log(dummy);

        verify(dummy1).update(dummy, stub);
    }
}
