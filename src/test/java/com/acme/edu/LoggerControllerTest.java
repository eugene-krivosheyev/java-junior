package com.acme.edu;

import com.acme.edu.commands.CommandAccumulateInfo;
import com.acme.edu.commands.Integer.ByteCommand;
import com.acme.edu.commands.Integer.IntCommand;
import com.acme.edu.controller.LocalController;
import com.acme.edu.saver.Saver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class LoggerControllerTest {
    private Saver mockSaver;
    private LocalController sut;


    @Before
    public void beforeTest() {
        mockSaver = mock(Saver.class);
        sut = new LocalController(mockSaver);
    }


    @Test
    public void twoIntegerShouldBeAccumulated() throws IOException{

        IntCommand firstStubIntCommand = mock(IntCommand.class);
        IntCommand secondStubIntCommand = mock(IntCommand.class);

        IntCommand infoStubIntCommand = mock(IntCommand.class);
        when(infoStubIntCommand.getDecoratedMessage()).thenReturn("test");

        CommandAccumulateInfo accumulateInfoMock = mock(CommandAccumulateInfo.class);
        when(accumulateInfoMock.isFlushNeeded()).thenReturn(false);
        when(accumulateInfoMock.getMessage()).thenReturn("test");
        when(accumulateInfoMock.getCommand()).thenReturn(infoStubIntCommand);

        when(secondStubIntCommand.accumulate(firstStubIntCommand)).thenReturn(accumulateInfoMock);

        sut.log(firstStubIntCommand);
        sut.log(secondStubIntCommand);
        sut.flush();

        verify(secondStubIntCommand).accumulate(firstStubIntCommand);

        verify(mockSaver).save("test");

        verify(accumulateInfoMock).isFlushNeeded();
        verify(accumulateInfoMock, never()).getMessage();
    }




    @Test
    public void controllerShouldFlushOnOverflow() throws IOException {
        final ByteCommand sut = new ByteCommand((byte)1);
        final ByteCommand accumulateCommand = new ByteCommand((byte)2);
        final ByteCommand overflowCommand = new ByteCommand((byte)125);
        final LocalController controller = new LocalController(mockSaver);

        controller.log(sut);
        controller.log(accumulateCommand);
        controller.log(overflowCommand);
        controller.flush();

        String message = overflowCommand.getDecoratedMessage();


//        assertThat(info.isFlushNeeded()).isFalse();
//        assertThat(message).isEqualTo("primitive: 125");
//        assertThat(overflowInfo.getMessage()).isEqualTo("primitive: 3");
//
//        assertThat(info.getCommand()).isEqualTo(sut);
//        assertThat(overflowInfo.getCommand()).isEqualTo(overflowCommand);
//        assertThat(overflowInfo.isFlushNeeded()).isTrue();


        verify(mockSaver).save("primitive: 3");
        verify(mockSaver).save("primitive: 125");
    }
}
