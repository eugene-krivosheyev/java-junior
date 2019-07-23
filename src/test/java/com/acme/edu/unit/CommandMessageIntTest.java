package com.acme.edu.unit;

import com.acme.edu.command.CommandMessage;
import com.acme.edu.command.CommandMessageInt;
import com.acme.edu.saver.Saver;
import org.junit.Before;
import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CommandMessageIntTest {
    private CommandMessageInt sutPositive;
    private CommandMessageInt sutNegative;

    @Before
    public void setUp() {
        sutPositive = new CommandMessageInt(5);
        sutNegative = new CommandMessageInt(-5);
    }

    @Test
    public void shouldUpdateWhenPositiveMessageAndNoOverflow() {
        CommandMessageInt nextCommandMock = mock(CommandMessageInt.class);
        Saver saverStub = mock(Saver.class);
        when(nextCommandMock.getMessage()).thenReturn(10);

        sutPositive.setAccumulator(100);
        sutPositive.update(nextCommandMock, saverStub);

        verify(nextCommandMock).setAccumulator(105);
    }

    @Test
    public void shouldUpdateWhenPositiveMessageAndOverflow() {
        CommandMessageInt nextCommandMock = mock(CommandMessageInt.class);
        Saver saverStub = mock(Saver.class);
        when(nextCommandMock.getMessage()).thenReturn(Integer.MAX_VALUE);

        sutPositive.setAccumulator(100);
        sutPositive.update(nextCommandMock, saverStub);

        verify(saverStub).save(105 + lineSeparator());
        verify(nextCommandMock).setAccumulator(Integer.MAX_VALUE);
    }

    @Test
    public void shouldUpdateWhenNegativeMessageAndNoOverflow() {
        CommandMessageInt nextCommandMock = mock(CommandMessageInt.class);
        Saver saverStub = mock(Saver.class);
        when(nextCommandMock.getMessage()).thenReturn(-5);

        sutNegative.setAccumulator(100);
        sutNegative.update(nextCommandMock, saverStub);

        verify(nextCommandMock).setAccumulator(95);
    }

    @Test
    public void shouldUpdateWhenNegativeMessageAndOverflow() {
        CommandMessageInt nextCommandMock = mock(CommandMessageInt.class);
        Saver saverStub = mock(Saver.class);
        when(nextCommandMock.getMessage()).thenReturn(Integer.MIN_VALUE);

        sutNegative.setAccumulator(1);
        sutNegative.update(nextCommandMock, saverStub);

        verify(saverStub).save(-4 + lineSeparator());
        verify(nextCommandMock).setAccumulator(Integer.MIN_VALUE);
    }

    @Test
    public void shouldFlushWhenTypeSwitched() {
        CommandMessage nextCommandMock = mock(CommandMessage.class);
        Saver saverStub = mock(Saver.class);

        sutPositive.setAccumulator(10);
        sutPositive.update(nextCommandMock, saverStub);

        verify(saverStub).save(15 + lineSeparator());
    }

    @Test
    public void shouldSetAccumulatorBeCalledWhenNexMessageZero() {
        CommandMessageInt sut = new CommandMessageInt(0);
        Saver stub = mock(Saver.class);
        CommandMessageInt nextCommand = mock(CommandMessageInt.class);

        sut.setAccumulator(0);
        sut.update(nextCommand, stub);

        verify(nextCommand).setAccumulator(0);
    }

    @Test
    public void shouldPrimitivePrefixBeCorrect(){
        CommandMessageInt sut = new CommandMessageInt(3);

        assertThat(sut.primitiveDecorator()).isEqualTo("primitive: ");
    }
}
