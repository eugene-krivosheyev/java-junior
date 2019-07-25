package com.acme.edu.unit;

import com.acme.edu.saver.FileSaver;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class FileSaverTest {
    @Test
    public void shouldWriteToFileWhenLogges() throws IOException {
        FileSaver sut = new FileSaver();

        sut.delete();
        sut.save("Abra 1438 Абдя");

       List<String> result =  Files.readAllLines((new File("Log_Info.txt")).toPath());
       assertThat(result).containsExactly("Abra 1438 Абдя");
    }
}
