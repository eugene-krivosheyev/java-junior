package com.acme.edu.unit;

import com.acme.edu.command.CommandMessageInt;
import com.acme.edu.command.CommandMessageString;
import com.acme.edu.exceptions.MaxValueReachedException;
import com.acme.edu.saver.ConsoleSaver;
import org.junit.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CommandMessageStringTest {

    CommandMessageString sut;

    @Test
    public void shouldFlushBeCalledWhenUpdateNonString() throws MaxValueReachedException, IOException {
        sut = new CommandMessageString("test");

        //CommandMessageInt stub = new CommandMessageInt(1);
        CommandMessageInt stub = mock(CommandMessageInt.class);
        ConsoleSaver stubSaver = mock(ConsoleSaver.class);

        sut.update(stub, stubSaver);

        verify(stubSaver).save("test" + lineSeparator());
    }

    @Test
    public void shouldFlushBeCalledAndStringCounterAddedWhenUpdateNonString() throws MaxValueReachedException, IOException {
        sut = new CommandMessageString("test");

        CommandMessageInt stub = mock(CommandMessageInt.class);
        ConsoleSaver stubSaver = mock(ConsoleSaver.class);
        sut.setSameStringCount(5);

        sut.update(stub, stubSaver);

        verify(stubSaver).save("test (x5)" + lineSeparator());
    }

    @Test
    public void shouldCounterIncreaseWhenSameStringUpdated() throws MaxValueReachedException, IOException {
        sut = new CommandMessageString("test");
        CommandMessageString stub = mock(CommandMessageString.class);
        ConsoleSaver stubSaver = mock(ConsoleSaver.class);

        when(stub.getMessage()).thenReturn("test");

        sut.setSameStringCount(2);
        sut.update(stub, stubSaver);

        verify(stub).setSameStringCount(3);
    }

    @Test
    public void shouldPrimitivePrefixBeCorrect() {
        CommandMessageString sut = new CommandMessageString("");

        assertThat(sut.primitiveDecorator()).isEqualTo("string: ");
    }

    @Test(expected = MaxValueReachedException.class)
    public void shouldExceptionBeThrownWhenTooManySameStrings() throws MaxValueReachedException {
        CommandMessageString sut = new CommandMessageString("");

        sut.setSameStringCount(Integer.MIN_VALUE);
    }
}
