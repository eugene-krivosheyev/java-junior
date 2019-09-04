package com.acme.edu;

import com.acme.edu.saver.FileSaver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;



import static org.fest.assertions.Assertions.assertThat;



public class FileSaverTest {

    private FileSaver fileSaver;
    private final String filename = "test.txt";

    @Before
    public void beforeTest() throws IOException {
        fileSaver = new FileSaver(filename, false);
    }

    @Test
    public void ShouldSaveLogToFile () {
        List<String> lines = null;
        try {
            fileSaver.save("test log");
            lines = Files.readAllLines(Paths.get(filename));
            assertThat(lines.size()).isEqualTo(1);
            assertThat(lines.get(0)).isEqualTo("test log");
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
