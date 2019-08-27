package com.acme.edu.mytest;

import com.acme.edu.LoggerController;
import com.acme.edu.commands.StringCommand;

import static com.acme.edu.commands.StringCommand.STRING_PREFIX;
import static org.fest.assertions.Assertions.assertThat;

import com.acme.edu.savers.ConsoleSaver;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class StringCommandTest {
    private LoggerController sut;

    @Before
    public void before() {
        sut = new LoggerController(new ConsoleSaver());
    }

    @Test
    public void shouldStringBeDecoratedCorrectly() {
        StringCommand stringCommand = new StringCommand("");
        String result = stringCommand.getDecorated();
        assertThat(result).contains(STRING_PREFIX);
    }

    @Test
    public void shouldTypeEqualsReturnTrueIfTypesAreEqual() {
        StringCommand firstStubCommand = mock(StringCommand.class);
        StringCommand secondStubCommand = mock(StringCommand.class);

        when(firstStubCommand.isTypeEquals(null)).thenReturn(false);
        when(secondStubCommand.isTypeEquals(firstStubCommand)).thenReturn(true);

        sut.log(firstStubCommand);
        sut.log(secondStubCommand);

        verify(firstStubCommand).isTypeEquals(null);
        verify(secondStubCommand).isTypeEquals(firstStubCommand);
    }
}
