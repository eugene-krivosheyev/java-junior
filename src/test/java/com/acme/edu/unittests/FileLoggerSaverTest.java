package com.acme.edu.unittests;

import com.acme.edu.loggerexceptions.LoggerSaverException;
import com.acme.edu.saver.FileLoggerSaver;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class FileLoggerSaverTest {
    FileLoggerSaver sut = new FileLoggerSaver("utf-8");
    File logsDirectory = new File(FileLoggerSaver.LOG_FILES_DIRECTORY);
    File currentLogFile = new File(sut.getLogFilename());

    public FileLoggerSaverTest() throws LoggerSaverException {
    }

    @Test
    public void createLogFile() throws LoggerSaverException {
        assertTrue(logsDirectory.exists());
        assertTrue(logsDirectory.isDirectory());
        assertNotEquals(0, logsDirectory.list().length);
        assertTrue(currentLogFile.exists());
    }

    @Test
    public void shouldWriteLinesInFile() throws LoggerSaverException, IOException {
        List<String> testStringsForWriting = Arrays.<String>asList("test string 1", "test string 2");
        String sutFilename = sut.getLogFilename();
        for (String testString : testStringsForWriting) {
            sut.save(testString);
        }

        assertTrue(lines(get(sutFilename)).collect(Collectors.toList()).containsAll(testStringsForWriting));
    }

    public void cleanLogFolder() {
        for (File f : logsDirectory.listFiles()) f.delete();
    }

    @Test
    public void shouldWriteManyLinesInSeveralFiles() throws LoggerSaverException, IOException {
        cleanLogFolder();
        List<String> testStringsForWriting = Arrays.<String>asList("test string", "another test string");
        String sutFilename = sut.getLogFilename();
        sut.setLogFileSizeInBytes(2 * 1024);
        for (int i = 0; i < 100; i++) {
            for (String testString : testStringsForWriting) {
                sut.save(testString);
            }
        }

        assertTrue(lines(get(sutFilename)).collect(Collectors.toList()).containsAll(testStringsForWriting));
        assertNotEquals(1, logsDirectory.list().length);

    }

}
