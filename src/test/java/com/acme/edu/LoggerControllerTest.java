package com.acme.edu;

import com.acme.edu.commands.IntCommand;
import com.acme.edu.saver.Saver;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoggerControllerTest {
    private Saver mockSaver;
    private Controller sut;


    @Before
    public void beforeTest() {
        mockSaver = mock(Saver.class);
        sut = new Controller(mockSaver);
    }


/*    @Test
    public void twoIntegerShouldBeAccumulatedAndNotSavedWithoutFlush() {

        IntCommand firstStubIntCommand = mock(IntCommand.class);
        IntCommand secondStubIntCommand = mock(IntCommand.class);

        when(secondStubIntCommand.isTypeEquals(firstStubIntCommand)).thenReturn(true);

        when(firstStubIntCommand.getMessage()).thenReturn(1);
        when(secondStubIntCommand.getMessage()).thenReturn(2);

        when(secondStubIntCommand.getDecoratedMessage()).thenReturn("nothing");

        sut.log(firstStubIntCommand);
        sut.log(secondStubIntCommand);


    }*/

}
