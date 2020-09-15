package com.acme.edu;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.controller.LoggerController;
import com.acme.edu.exception.LogException;
import com.acme.edu.saver.FileSaver;
import com.acme.edu.saver.LoggerSaver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.linesOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileSaverControllerTest {
    private LoggerController loggerController;
    private LoggerSaver loggerSaver;
    private File testFile;

    @Before
    public void setUp() {
        testFile = new File("test_log.txt");
        loggerSaver = new FileSaver(testFile.getName());
        loggerController = new LoggerController(loggerSaver);
    }

    @After
    public void clean() {
        testFile.delete();
    }

    @Test
    public void shouldSave() throws LogException {
        LoggerCommand command = mock(LoggerCommand.class);
        when(command.toString()).thenReturn("primitive: 3");

        loggerController.log(command);
        loggerController.flush(null);

        assertThat(linesOf(testFile)).containsExactly("primitive: 3");
    }
}
