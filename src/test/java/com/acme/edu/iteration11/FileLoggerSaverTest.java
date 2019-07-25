package com.acme.edu.iteration11;

import com.acme.edu.LoggerController;
import com.acme.edu.command.IntCommand;
import com.acme.edu.command.StringCommand;
import com.acme.edu.exceptions.EmptySaverException;
import com.acme.edu.saver.FileLoggerSaver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class FileLoggerSaverTest {
    FileLoggerSaver fileLoggerSaver;
    LoggerController loggerController;
    BufferedReader in;

    @Before
    public void setUp() throws IOException {
        fileLoggerSaver = new FileLoggerSaver("journal.txt");
        loggerController = new LoggerController(fileLoggerSaver);
    }

    @After
    public void closeResources() throws IOException {
        in.close();
    }

    @Test
    public void shouldSaveStringToFileWhenLog() throws EmptySaverException, IOException {
        loggerController.log(new StringCommand("Кирилл"));
        loggerController.flush();
        loggerController.close();
        in = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream("journal.txt")),"UTF-16"));
        String str = in.readLine();
        Assert.assertEquals("Кирилл",str);
    }

    @Test
    public void shouldSaveIntToFileWhenLog() throws EmptySaverException, IOException {
        loggerController.log(new IntCommand(1));
        loggerController.flush();
        loggerController.close();
        in = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream("journal.txt")),"UTF-16"));
        String str = in.readLine();
        Assert.assertEquals("1",str);
    }
}
