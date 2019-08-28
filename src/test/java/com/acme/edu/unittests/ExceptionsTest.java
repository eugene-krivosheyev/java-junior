package com.acme.edu.unittests;

import com.acme.edu.LoggerController;
import com.acme.edu.commands.PrimitiveCommand;
import com.acme.edu.exceptions.IntegerMaxOverflowException;
import com.acme.edu.exceptions.IntegerMinOverflowException;
import com.acme.edu.exceptions.SaverException;
import com.acme.edu.savers.ConsoleSaver;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import static org.mockito.Mockito.*;

public class ExceptionsTest {
    @Test(expected = SaverException.class)
    public void shouldThrowSaverExceptionWhenSaveErrorHappens() throws SaverException {
        PrimitiveCommand stubIntCommand = mock(PrimitiveCommand.class);
        Whitebox.setInternalState(stubIntCommand, "buffer", 1);
        ConsoleSaver mockSaver = mock(ConsoleSaver.class);
        doCallRealMethod().when(stubIntCommand).flush(mockSaver);
        //TODO add any
        doThrow(SaverException.class).when(mockSaver).save("primitive: 1");

        final LoggerController sut = new LoggerController(mockSaver);
        sut.run(stubIntCommand);
        sut.close();
    }

    @Test(expected = IntegerMaxOverflowException.class)
    public void shouldThrowIntegerMaxOverflowExceptionWhenOverflowHappens() throws IntegerMaxOverflowException, IntegerMinOverflowException {
        PrimitiveCommand stubIntCommand = mock(PrimitiveCommand.class);
        Whitebox.setInternalState(stubIntCommand, "buffer", Integer.MAX_VALUE);

        doThrow(IntegerMaxOverflowException.class).when(stubIntCommand).checkOverflow(1);

        final PrimitiveCommand sut = new PrimitiveCommand(Integer.MAX_VALUE);
        sut.checkOverflow(1);
    }

    @Test(expected = IntegerMinOverflowException.class)
    public void shouldThrowIntegerMinOverflowExceptionWhenOverflowHappens() throws IntegerMaxOverflowException, IntegerMinOverflowException {
        PrimitiveCommand stubIntCommand = mock(PrimitiveCommand.class);
        Whitebox.setInternalState(stubIntCommand, "buffer", Integer.MIN_VALUE);

        doThrow(IntegerMaxOverflowException.class).when(stubIntCommand).checkOverflow(-1);

        final PrimitiveCommand sut = new PrimitiveCommand(Integer.MIN_VALUE);
        sut.checkOverflow(-1);
    }

}
