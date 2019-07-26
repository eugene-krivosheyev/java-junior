package com.acme.edu.iteration11;

import com.acme.edu.exceptions.EmptySaverException;
import com.acme.edu.saver.FileLoggerSaver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class FileLoggerSaverTest {
    private FileLoggerSaver fileLoggerSaver;
    private BufferedReader in;

    @Before
    public void setUp() throws IOException {
        fileLoggerSaver = new FileLoggerSaver("journal.txt");
    }

    @After
    public void closeResources() throws IOException {
        in.close();
    }

    @Test
    public void shouldSaveStringToFileWhenLog() throws EmptySaverException, IOException {
        fileLoggerSaver.save("Кирилл");
        fileLoggerSaver.close();

        setUpReader();

        String str = in.readLine();
        Assert.assertEquals("Кирилл", str);
    }

    @Test
    public void shouldSaveIntToFileWhenLog() throws EmptySaverException, IOException {
        fileLoggerSaver.save("1");
        fileLoggerSaver.close();

        setUpReader();

        String str = in.readLine();
        Assert.assertEquals("1", str);
    }

    private void setUpReader() throws IOException {
        in = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream("journal.txt")), "UTF-16"));
    }
}
