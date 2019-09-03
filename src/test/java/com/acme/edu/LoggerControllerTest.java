package com.acme.edu;

import com.acme.edu.Saver.SuperSaver;
import com.acme.edu.commands.CharCommand;
import com.acme.edu.commands.IntCommand;
import com.acme.edu.commands.StringCommand;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoggerControllerTest {
    private SuperSaver saverMock;

    @Before
    public void setUp() {
        saverMock = mock(SuperSaver.class);
    }

    @Test
    public void shouldAccumulateCommandWhenSameIntTypeCommand() {
        IntCommand firstStubCommand = mock(IntCommand.class);
        when(firstStubCommand.isTypeEqual(null)).thenReturn(false);

        IntCommand secondStubCommand = mock(IntCommand.class);
        IntCommand result = mock(IntCommand.class);
        when(secondStubCommand.isTypeEqual(firstStubCommand)).thenReturn(true);
        when(secondStubCommand.isSaveRequired(firstStubCommand)).thenReturn(false);
        when(secondStubCommand.accumulate(firstStubCommand)).thenReturn(result);

        String resultMessage = "3";
        when(result.getDecorated()).thenReturn(resultMessage);

        final LoggerController sut = new LoggerController(saverMock);

        sut.log(firstStubCommand);
        sut.log(secondStubCommand);
        sut.flush();

        //Interaction-based testing:
        verify(firstStubCommand).isTypeEqual(null);
        verify(secondStubCommand).isTypeEqual(firstStubCommand);
        verify(secondStubCommand).isSaveRequired(firstStubCommand);
        verify(secondStubCommand).accumulate(firstStubCommand);
        verify(saverMock).save(resultMessage);
    }

    @Test
    public void shouldSaveBothWhenTwoDifferentTypes(){
        IntCommand firstStubCommand = mock(IntCommand.class);
        when(firstStubCommand.isTypeEqual(null)).thenReturn(false);
        when(firstStubCommand.getDecorated()).thenReturn("1");

        StringCommand secondStudCommand = mock(StringCommand.class);
        when(secondStudCommand.isTypeEqual(firstStubCommand)).thenReturn(false);
        when(secondStudCommand.getDecorated()).thenReturn("str");

        final LoggerController sut = new LoggerController(saverMock);

        sut.log(firstStubCommand);
        sut.log(secondStudCommand);
        sut.flush();

        verify(firstStubCommand).isTypeEqual(null);
        verify(secondStudCommand).isTypeEqual(firstStubCommand);
        verify(firstStubCommand).getDecorated();
        verify(saverMock).save("1");
        verify(saverMock).save("str");
    }

    @Test
    public void shouldSaveBothWhenTwoCharCommands(){
        CharCommand firstStubCommand = mock(CharCommand.class);
        when(firstStubCommand.isTypeEqual(null)).thenReturn(false);
        when(firstStubCommand.getDecorated()).thenReturn("c");

        CharCommand secondStubCommand = mock(CharCommand.class);
        when(secondStubCommand.isTypeEqual(firstStubCommand)).thenReturn(true);
        when(secondStubCommand.isSaveRequired(firstStubCommand)).thenReturn(true);
        when(secondStubCommand.getDecorated()).thenReturn("b");

        final LoggerController sut = new LoggerController(saverMock);

        sut.log(firstStubCommand);
        sut.log(secondStubCommand);
        sut.flush();

        verify(firstStubCommand).isTypeEqual(null);
        verify(secondStubCommand).isTypeEqual(firstStubCommand);
        verify(secondStubCommand).isSaveRequired(firstStubCommand);
        verify(firstStubCommand).getDecorated();
        verify(secondStubCommand).getDecorated();
        verify(saverMock).save("c");
        verify(saverMock).save("b");

    }
}
