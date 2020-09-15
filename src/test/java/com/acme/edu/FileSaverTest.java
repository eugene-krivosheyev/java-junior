package com.acme.edu;

import com.acme.edu.command.IntCommand;
import com.acme.edu.exception.SaveException;
import com.acme.edu.saver.FileSaver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.linesOf;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileSaverTest {
    private FileSaver fileSaver;
    private File testFile;

    @Before
    public void setUp() {
        testFile = new File("test_log.txt");
        fileSaver = new FileSaver(testFile.getName());

    }

    @After
    public void clean() {
        testFile.delete();
    }

    @Test
    public void shouldSaveMessageWhenLogToFile() throws SaveException {
        IntCommand command = mock(IntCommand.class);
        when(command.toString()).thenReturn("primitive: 3");

        fileSaver.saveMessage(command);

        assertThat(linesOf(testFile)).containsExactly("primitive: 3");
    }

    @Test(expected = SaveException.class)
    public void shouldThrowExceptionWhenFileNameIsNull() throws SaveException {
        FileSaver fileSaver = new FileSaver(null);
        IntCommand command = mock(IntCommand.class);

        fileSaver.saveMessage(command);
    }

    @Test
    public void shouldThrowExceptionWithRightMessageWhenFileNameIsNull() {
        FileSaver fileSaver = new FileSaver(null);
        IntCommand command = mock(IntCommand.class);

        try {
            fileSaver.saveMessage(command);
        } catch (SaveException e) {
            assertEquals("file null does not exist", e.getMessage());
        }
    }
}
