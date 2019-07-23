package com.acme.edu.unit;

import com.acme.edu.command.CommandMessageInt;
import com.acme.edu.command.CommandMessageString;
import com.acme.edu.saver.ConsoleSaver;
import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CommandMessageStringTest {

    CommandMessageString sut;

    @Test
    public void shouldFlushBeCalledWhenUpdateNonString() {
        sut = new CommandMessageString("test");

        //CommandMessageInt stub = new CommandMessageInt(1);
        CommandMessageInt stub = mock(CommandMessageInt.class);
        ConsoleSaver stubSaver = mock(ConsoleSaver.class);

        sut.update(stub, stubSaver);

        verify(stubSaver).save("test" + lineSeparator());
    }

    @Test
    public void shouldFlushBeCalledAndStringCounterAddedWhenUpdateNonString() {
        sut = new CommandMessageString("test");

        CommandMessageInt stub = mock(CommandMessageInt.class);
        ConsoleSaver stubSaver = mock(ConsoleSaver.class);
        sut.setSameStringCount(5);

        sut.update(stub, stubSaver);

        verify(stubSaver).save("test (x5)" + lineSeparator());
    }

    @Test
    public void shouldCounterIncreaseWhenSameStringUpdated() {
        sut = new CommandMessageString("test");
        CommandMessageString stub = mock(CommandMessageString.class);
        ConsoleSaver stubSaver = mock(ConsoleSaver.class);

        when(stub.getMessage()).thenReturn("test");

        sut.setSameStringCount(2);
        sut.update(stub, stubSaver);

        verify(stub).setSameStringCount(3);
    }

    @Test
    public void shouldPrimitivePrefixBeCorrect(){
        CommandMessageString sut = new CommandMessageString("");

        assertThat(sut.primitiveDecorator()).isEqualTo("string: ");
    }
}
