package com.acme.edu.unittests;

import com.acme.edu.LoggerController;
import com.acme.edu.commands.AccumulateCommand;
import com.acme.edu.commands.CharCommand;
import com.acme.edu.commands.PrimitiveCommand;
import com.acme.edu.commands.ReferenceCommand;
import com.acme.edu.savers.ConsoleSaver;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class UnitTest {
    @Test
    public void shouldDecorateChar() {
        CharCommand sut = new CharCommand("a");
        assertEquals("char: a",  sut.decorate());
    }

    @Test
    public void shouldDecorateReference() {
        ReferenceCommand sut = new ReferenceCommand(String.valueOf(new Object()));
        assertTrue(sut.decorate().contains("@"));
    }

    @Test
    public void shouldRunFlushWhenPrevCommandNull() {
        AccumulateCommand mockAccumulate = mock(AccumulateCommand.class);
        PrimitiveCommand stubIntCommand = mock(PrimitiveCommand.class);
        Whitebox.setInternalState(stubIntCommand, "buffer", 1);
        ConsoleSaver mockSaver = mock(ConsoleSaver.class);
        when(stubIntCommand.decorate()).thenReturn("primitive: 1");

        final LoggerController sut = new LoggerController(mockSaver, mockAccumulate);
        sut.run(stubIntCommand);

        verify(mockAccumulate).flush(mockSaver);
    }

    @Test
    public void shouldFlushWhenCloseAndPrevCommandNotNull() {
        PrimitiveCommand stubIntCommand = mock(PrimitiveCommand.class);
        Whitebox.setInternalState(stubIntCommand, "buffer", 1);
        ConsoleSaver dummySaver = mock(ConsoleSaver.class);

        final LoggerController sut = new LoggerController(dummySaver);
        sut.run(stubIntCommand);
        sut.close();

        verify(stubIntCommand).flush(dummySaver);
    }

    @Test
    public void shouldNotFlushWhenCloseAndPrevCommandNull() {
        PrimitiveCommand stubIntCommand = mock(PrimitiveCommand.class);
        ConsoleSaver dummySaver = mock(ConsoleSaver.class);

        final LoggerController sut = new LoggerController(dummySaver);
        sut.close();

        doNothing().when(stubIntCommand).flush(dummySaver);
    }

    @Test
    public void shouldFlushAccumulatedWhenSwitchedToDecorated() {
        AccumulateCommand mockAccumulate = mock(AccumulateCommand.class);
        AccumulateCommand mockAccumulate2 = mock(AccumulateCommand.class);
        PrimitiveCommand stubIntCommand = mock(PrimitiveCommand.class);
        CharCommand stubCharCommand = mock(CharCommand.class);
        Whitebox.setInternalState(stubIntCommand, "buffer", 1);
        Whitebox.setInternalState(stubCharCommand, "message", "a");
        ConsoleSaver mockSaver = mock(ConsoleSaver.class);
        when(mockAccumulate.isTypeTheSame(mockAccumulate2)).thenReturn(false);

        final LoggerController sut = new LoggerController(mockSaver, mockAccumulate);
        sut.run(stubIntCommand);
        sut.run(stubCharCommand);

        verify(mockAccumulate).flush(mockSaver);
    }

    @Test
    public void shouldAccumulateWhenCommandsAreEquals() {
        AccumulateCommand stubIntCommand = mock(PrimitiveCommand.class);
        Whitebox.setInternalState(stubIntCommand, "buffer", 1);
        ConsoleSaver mockSaver = mock(ConsoleSaver.class);
        when(stubIntCommand.isTypeTheSame(stubIntCommand)).thenReturn(true);

        final LoggerController sut = new LoggerController(mockSaver);
        sut.run(stubIntCommand);
        sut.run(stubIntCommand);

        verify(stubIntCommand).isTypeTheSame(stubIntCommand);
        verify(stubIntCommand).accumulate(stubIntCommand, mockSaver);
    }
}
