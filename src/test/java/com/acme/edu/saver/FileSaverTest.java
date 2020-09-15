package com.acme.edu.saver;

import com.acme.edu.exception.SaveException;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileSaverTest {

    private FileSaver fileSaver;
    private File file;

    @Before
    public void setUp() {
        file = new File("src"
                + File.pathSeparator + "test"
                + File.pathSeparator + "resources"
                + "logbook.txt");
        fileSaver = new FileSaver("src"
                + File.pathSeparator + "test"
                + File.pathSeparator + "resources"
                + "logbook.txt");
    }

    @After
    public void reset() {
        file.delete();
    }


    @Test
    public void shouldLogStrInFileWhenAsked() throws SaveException, IOException {

        //region when
        fileSaver.save("test string");
        //endregion

        //region then
        List<String> strings = Files.readAllLines(file.toPath());
        assertThat(strings.size()).isEqualTo(1);
        assertThat(strings.get(0)).isEqualTo("test string");
        //endregion
    }
}