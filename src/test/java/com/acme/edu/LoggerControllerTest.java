package com.acme.edu;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class LoggerControllerTest implements SysoutCaptureAndAssertionAbility {
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test @Ignore
    public void shouldAccumulateCommandWhenSameIntTypeCommand() {
        SuperAccumulator dummyAccumulator = mock(SuperCurrentAccumulator.class);
        SuperSaver mockSaver = mock(SuperConsoleSaver.class);

        IntCommand firstStubCommand = mock(IntCommand.class);
        when(firstStubCommand.isTypeEquals(null)).thenReturn(false);
        // when(firstStubCommand.getDecorated()).thenReturn("first command");

        IntCommand secondStubCommand = mock(IntCommand.class);
        when(secondStubCommand.isTypeEquals(null)).thenReturn(false);
        when(secondStubCommand.isTypeEquals(firstStubCommand)).thenReturn(true);
        when(firstStubCommand.accumulate(secondStubCommand).isOverflow()).thenReturn(false);

        //when(firstStubCommand.getMessage()).thenReturn(1);
        //when(secondStubCommand.getMessage()).thenReturn(2);
        //doReturn(2).when(secondStubCommand).getMessage();

        final LoggerController sut = new LoggerController(dummyAccumulator, mockSaver);

        sut.log(firstStubCommand);
        sut.log(secondStubCommand);

        //Interaction-based testing:
        verify(firstStubCommand).isTypeEquals(null);
        //verify(mockSaver).save("first command");
        //verify(secondStubCommand).isTypeEquals(firstStubCommand);
        //verify(firstStubCommand).accumulate(secondStubCommand);

    }
}
