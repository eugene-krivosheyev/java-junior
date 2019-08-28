package com.acme.edu;

import com.acme.edu.commands.IntCommand;
import com.acme.edu.commands.StringCommand;
import com.acme.edu.savers.Saver;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by kate-c on 28/08/2019.
 */
public class LoggerControllerTest {
    @Test
    public void shouldAccumulateWhenSameIntTypeCommand() {
        Saver mockSaver = mock(Saver.class);
        final LoggerController sut = new LoggerController(mockSaver);

        IntCommand firstStubCommand = mock(IntCommand.class);
        when(firstStubCommand.getMessage()).thenReturn(1);

        IntCommand secondStubCommand = mock(IntCommand.class);
        when(firstStubCommand.isTypeEqual(secondStubCommand)).thenReturn(true);
        when(secondStubCommand.getMessage()).thenReturn(2);

        sut.log(firstStubCommand);
        sut.log(secondStubCommand);

        verify(firstStubCommand).isTypeEqual(secondStubCommand);
        verify(firstStubCommand).accumulate(secondStubCommand,mockSaver);
    }

    @Test
    public void shouldFlushWhenOtherTypeCommand(){
        Saver mockSaver = mock(Saver.class);
        final LoggerController sut = new LoggerController(mockSaver);
        IntCommand stubCommand = mock(IntCommand.class);
        final StringCommand otherTypeCommand = new StringCommand("str");

        when(stubCommand.isTypeEqual(otherTypeCommand)).thenReturn(false);

        sut.log(stubCommand);
        sut.log(otherTypeCommand);

        verify(stubCommand).isTypeEqual(otherTypeCommand);
        verify(stubCommand).flush(mockSaver);

    }
    @Test
    public void shouldFlush() {
        Saver mockSaver = mock(Saver.class);
        final LoggerController sut = new LoggerController(mockSaver);
        final IntCommand firstCommand = mock(IntCommand.class);
        sut.log(firstCommand);
        sut.flush();

        verify(firstCommand).flush(mockSaver);
    }

}
