package com.acme.edu;

import com.acme.edu.command.IntCommand;
import com.acme.edu.command.LoggerCommand;
import com.acme.edu.command.StringCommand;
import com.acme.edu.exception.FlushException;
import com.acme.edu.exception.LogException;
import com.acme.edu.exception.SaveException;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.FileSaver;
import com.acme.edu.saver.LoggerSaver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class LoggerControllerTest {

    private LoggerSaver stubSaver;
    private LoggerController controller;
    private LoggerCommand command;
    private File file;

    @Before
    public void setUp() {
        stubSaver = mock(ConsoleSaver.class);
        controller = new LoggerController(stubSaver);
        command = mock(LoggerCommand.class);
        file = new File("src"
                + File.pathSeparator + "test"
                + File.pathSeparator + "resources"
                + "logbook.txt");
    }

    @After
    public void reset() {
        file.delete();
    }

    @Test
    public void shouldNotLogWhenFirstMessage() throws LogException, SaveException {
        //region given
        when(command.getDecoratedSelf()).thenReturn("str");
        //endregion

        //region when
        controller.log(command);
        //endregion

        //region then
        verify(stubSaver, times(0)).save(any());
        //endregion
    }

    @Test
    public void shouldLogDecoratedWhenAllowedFlush() throws LogException, SaveException {
        //region given
        when(command.getDecoratedSelf()).thenReturn("str");
        when(command.checkFlush(any(LoggerCommand.class))).thenReturn(true);
        //endregion

        //region when
        controller.log(command);
        controller.log(command);
        //endregion

        //region then
        verify(command, times(1)).checkFlush(command);
        verify(command, times(1)).getDecoratedSelf();
        verify(stubSaver, times(1)).save(anyString());
        //endregion
    }

    @Test
    public void shouldAccumulateButNotLogWhenDisallowedFlush() throws SaveException, LogException {
        //region given
        when(command.getDecoratedSelf()).thenReturn("str");
        when(command.checkFlush(any(LoggerCommand.class))).thenReturn(false);
        //endregion

        //region when
        controller.log(command);
        controller.log(command);
        //endregion

        //region then
        verify(command, times(1)).checkFlush(command);
        verify(command, times(1)).accumulate(command);
        verify(stubSaver, times(0)).save(anyString());
        //endregion
    }

    @Test
    public void shouldLogToMoreThanOneSaver() throws LogException, FlushException, SaveException {
        //region given
        LoggerSaver stubSaver1 = mock(ConsoleSaver.class);
        LoggerSaver stubSaver2 = mock(ConsoleSaver.class);
        when(command.getDecoratedSelf()).thenReturn("str");
        controller = new LoggerController(stubSaver1, stubSaver2);
        //endregion

        //region when
        controller.log(command);
        controller.flush();
        //endregion

        //region then
        verify(stubSaver1, times(1)).save(anyString());
        verify(stubSaver2, times(1)).save(anyString());
        //endregion
    }

    @Test
    public void shouldLogToFileWhenAsked() throws LogException, FlushException, IOException {

        //region given
        controller = new LoggerController(
                new FileSaver("src"
                    + File.pathSeparator + "test"
                    + File.pathSeparator + "resources"
                    + "logbook.txt"));
        //endregion

        //region when
        controller.log(new IntCommand(0));
        controller.log(new StringCommand("str"));
        controller.flush();
        //endregion

        //region then
        List<String> strings = Files.readAllLines(file.toPath());
        assertThat(strings.size()).isEqualTo(2);
        assertThat(strings.get(0)).isEqualTo("primitive: 0");
        assertThat(strings.get(1)).isEqualTo("string: str");
        //endregion

    }
}
