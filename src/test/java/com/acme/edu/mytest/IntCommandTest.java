package com.acme.edu.mytest;

import com.acme.edu.LoggerController;
import com.acme.edu.commands.IntCommand;
import com.acme.edu.commands.StringCommand;
import com.acme.edu.savers.ConsoleSaver;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class IntCommandTest {
    private LoggerController sut;

    @Before
    public void before() {
        sut = new LoggerController(new ConsoleSaver());
    }

    @Test
    public void shouldTypeEqualsReturnTrueIfTypesAreEqual() {
        IntCommand firstStubCommand = mock(IntCommand.class);
        IntCommand secondStubCommand = mock(IntCommand.class);

        when(firstStubCommand.isTypeEquals(null)).thenReturn(false);
        when(secondStubCommand.isTypeEquals(firstStubCommand)).thenReturn(true);

        sut.log(firstStubCommand);
        sut.log(secondStubCommand);

        verify(firstStubCommand).isTypeEquals(null);
        verify(secondStubCommand).isTypeEquals(firstStubCommand);
    }
}
