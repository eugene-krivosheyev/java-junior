package com.acme.edu.test;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.exceptions.FileLoggerSaverException;
import com.acme.edu.saver.FileLoggerSaver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileLoggerSaverTest implements SysoutCaptureAndAssertionAbility {
    private FileLoggerSaver saver;

    @Before
    public void setUp() {
        saver = new FileLoggerSaver("test.txt");
        resetOut();
        captureSysout();
    }

    @Test
    public void messageIsPrintedToFileWhenSave() throws FileLoggerSaverException, IOException {
        saver.save("HW!");
        List<String> lines = Files.readAllLines(Paths.get("test.txt"));
        lines.forEach(System.out::println);

        assertSysoutEquals("HW!"+System.lineSeparator());
    }

    @Test(expected = FileLoggerSaverException.class)
    public void shouldThrowExceptionIfMessageIsNull() throws FileLoggerSaverException {
        saver.save(null);
    }

    @Test(expected = NullPointerException.class)
    public void should() throws FileLoggerSaverException {
        saver = new FileLoggerSaver(null);
        saver.save("HW!");
    }

}
