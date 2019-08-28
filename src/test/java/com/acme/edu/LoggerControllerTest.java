package com.acme.edu;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;
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

        IntCommand secondStubCommand = mock(IntCommand.class);
        IntCommand thirdStubCommand = mock(IntCommand.class);
        when(secondStubCommand.isTypeEquals(null)).thenReturn(false);
        when(secondStubCommand.isTypeEquals(firstStubCommand)).thenReturn(true);
        when(firstStubCommand.getMessage()).thenReturn(1);
        when(secondStubCommand.getMessage()).thenReturn(2);
        when(firstStubCommand.accumulate(secondStubCommand)).thenReturn(thirdStubCommand);
        when(thirdStubCommand.isOverflow()).thenReturn(false);

        final LoggerController sut = new LoggerController(dummyAccumulator, mockSaver);

        sut.log(firstStubCommand);
        sut.log(secondStubCommand);
        sut.flush();

        //Interaction-based testing:
        verify(firstStubCommand).isTypeEquals(null);
        verify(secondStubCommand).isTypeEquals(firstStubCommand);

    }
}
