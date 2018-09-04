package com.acme.edu.logger;

import com.acme.edu.controller.LogOperationException;
import com.acme.edu.saver.FileSaver;
import com.acme.edu.saver.SaveException;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;
import static org.junit.Assert.assertTrue;

/**
 * Created by Java_1 on 04.09.2018.
 */
public class FileSaverTest {

    private FileSaver sut = new FileSaver();

    @Test
    public void shouldLogStringToFile() throws SaveException, LogOperationException, IOException{
        sut.save("test message");
        Stream<String> stringStream = lines(get("logfile.txt"));
        assertTrue(stringStream.anyMatch(elem -> elem.equals("test message")));
    }

    @Test(expected = LogOperationException.class)
    public void shouldThrowExceptionWhenFileIsVeryBig() throws SaveException, LogOperationException, IOException{
        sut.setMaxSize(10);
        sut.save("test message");

    }
}