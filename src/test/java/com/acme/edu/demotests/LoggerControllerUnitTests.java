package com.acme.edu.demotests;

import com.acme.edu.LoggerController;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.command.Command;
import com.acme.edu.command.IntCommand;
import com.acme.edu.command.StringCommand;
import com.acme.edu.exceptions.LogException;
import com.acme.edu.exceptions.SaveException;
import com.acme.edu.save.Saver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class LoggerControllerUnitTests implements SysoutCaptureAndAssertionAbility {
    private LoggerController sut;
    private Saver saverMock;

    @Before
    public void setUP() {
        saverMock = mock(Saver.class);
        sut = new LoggerController(saverMock);
    }

    @Test
    public void shouldLaunchLoggerWithSaver() {
        assertThat(sut).isNotNull();
    }

    @Test
    public void shouldSaverWriteCommand() throws LogException, IOException, SaveException {
        IntCommand stub = mock(IntCommand.class);

        sut.log(stub);
        sut.flushBuffers();

        verify(saverMock).save(stub);
    }

    @Test
    public  void shouldLoggerSaveSameTypeCommand() throws LogException, IOException, SaveException {
        StringCommand firstCmd = mock(StringCommand.class);
        StringCommand secondCmd = mock(StringCommand.class);
        when(firstCmd.isSameType(secondCmd)).thenReturn(true);

        sut.log(firstCmd);
        sut.log(secondCmd);
        sut.flushBuffers();

        verify(saverMock, times(1)).save(sut.getCurrentCommand());
    }

    @Test
    public void shouldLoggerSaveOverflowedCommand() throws IOException, SaveException {
        IntCommand firstCmd = mock(IntCommand.class);
        IntCommand secondCmd = mock(IntCommand.class);
        when((firstCmd).isOverflow(secondCmd)).thenReturn(true);

        sut.log(firstCmd);
        sut.log(secondCmd);
        sut.flushBuffers();

        verify(saverMock).save(firstCmd);
        verify(saverMock).save(secondCmd);
    }

    @Test
    public void shouldLoggerSaveNullCommand() throws LogException, IOException, SaveException {
        Command cmd = null;

        sut.log(null);
        sut.flushBuffers();

        verify(saverMock, times(0)).save(cmd);
    }
}
