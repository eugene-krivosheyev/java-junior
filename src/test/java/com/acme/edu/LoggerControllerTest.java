package com.acme.edu;

import com.acme.edu.commands.CommandAccumulateInfo;
import com.acme.edu.commands.Integer.IntCommand;
import com.acme.edu.commands.StringCommand;
import com.acme.edu.saver.Saver;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoggerControllerTest {
    private Saver mockSaver;
    private Controller sut;


    @Before
    public void beforeTest() {
        mockSaver = mock(Saver.class);
        sut = new Controller(mockSaver);
    }


    @Test
    public void twoIntegerShouldBeAccumulatedWithoutFlush() {

        IntCommand firstStubIntCommand = mock(IntCommand.class);
        IntCommand secondStubIntCommand = mock(IntCommand.class);

        CommandAccumulateInfo accumulateInfoMock = mock(CommandAccumulateInfo.class);
        when(accumulateInfoMock.isFlushNeeded()).thenReturn(false);
        when(accumulateInfoMock.getMessage()).thenReturn("test");

        when(secondStubIntCommand.accumulate(firstStubIntCommand)).thenReturn(accumulateInfoMock);

        sut.log(firstStubIntCommand);
        sut.log(secondStubIntCommand);

        verify(secondStubIntCommand).accumulate(firstStubIntCommand);
        verify(mockSaver, never()).save("test");
        verify(accumulateInfoMock).isFlushNeeded();
        verify(accumulateInfoMock, never()).getMessage();
    }


    @Test
    public void infoFromFirstCommandShouldBeFlushedIfTryToAccumulateWithAnotherType() {
        IntCommand firstStubIntCommand = mock(IntCommand.class);
        StringCommand secondStubIntCommand = mock(StringCommand.class);

        CommandAccumulateInfo accumulateInfoMock = mock(CommandAccumulateInfo.class);

        when(accumulateInfoMock.isFlushNeeded()).thenReturn(true);
        when(accumulateInfoMock.getMessage()).thenReturn("test");
        when(secondStubIntCommand.accumulate(firstStubIntCommand)).thenReturn(accumulateInfoMock);

        sut.log(firstStubIntCommand);
        sut.log(secondStubIntCommand);

        verify(secondStubIntCommand).accumulate(firstStubIntCommand);
        verify(mockSaver).save("test");
        verify(accumulateInfoMock).isFlushNeeded();
        verify(accumulateInfoMock).getMessage();
    }
}
