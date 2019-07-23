package com.acme.edu.unit;

import com.acme.edu.command.CommandMessageInt;
import com.acme.edu.saver.Saver;
import org.junit.Before;
import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.mockito.Mockito.*;

public class CommandMessageIntTest {
    private CommandMessageInt sut_positive;
    private CommandMessageInt sut_negative;

    @Before
    public void setUp() {
        sut_positive = new CommandMessageInt(5);
        sut_negative = new CommandMessageInt(-5);
    }

    @Test
    public void shouldUpdateWhenPositiveMessageAndNoOverflow() {
        CommandMessageInt nextCommandMock = mock(CommandMessageInt.class);
        Saver saverStub = mock(Saver.class);
        when(nextCommandMock.getMessage()).thenReturn(10);

        sut_positive.setAccumulator(100);
        sut_positive.update(nextCommandMock, saverStub);

        verify(nextCommandMock).setAccumulator(105);
    }

    @Test
    public void shouldUpdateWhenPositiveMessageAndOverflow() {
        CommandMessageInt nextCommandMock = mock(CommandMessageInt.class);
        Saver saverStub = mock(Saver.class);
        when(nextCommandMock.getMessage()).thenReturn(Integer.MAX_VALUE);

        sut_positive.setAccumulator(100);
        sut_positive.update(nextCommandMock, saverStub);

        verify(saverStub).save(105 + lineSeparator());
        verify(nextCommandMock).setAccumulator(Integer.MAX_VALUE);
    }

    @Test
    public void shouldUpdateWhenNegativeMessageAndNoOverflow() {
        CommandMessageInt nextCommandMock = mock(CommandMessageInt.class);
        Saver saverStub = mock(Saver.class);
        when(nextCommandMock.getMessage()).thenReturn(-5);

        sut_negative.setAccumulator(100);
        sut_negative.update(nextCommandMock, saverStub);

        verify(nextCommandMock).setAccumulator(90);
    }

    @Test
    public void shouldUpdateWhenNegativeMessageAndOverflow() {
        CommandMessageInt nextCommandMock = mock(CommandMessageInt.class);
        Saver saverStub = mock(Saver.class);
        when(nextCommandMock.getMessage()).thenReturn(Integer.MIN_VALUE);

        sut_negative.setAccumulator(1);
        sut_negative.update(nextCommandMock, saverStub);

        verify(saverStub).save(-4 + lineSeparator());
        verify(nextCommandMock).setAccumulator(Integer.MIN_VALUE);
    }
}
