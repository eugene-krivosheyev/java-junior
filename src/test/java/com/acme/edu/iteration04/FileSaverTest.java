package com.acme.edu.iteration04;

import com.acme.edu.LoggerFacade;
import com.acme.edu.exception.LoggerException;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.assertEquals;

public class FileSaverTest {

    private String getResult() throws IOException {
        String fileName = "test.txt";

        return Files.lines(Paths.get(fileName)).reduce("",
                (firstLine, secondLine) -> firstLine + lineSeparator() + secondLine);
    }

    @Test
    public void shouldLogIntWhenItsLogged() throws LoggerException, IOException {
        LoggerFacade.log(1);
        LoggerFacade.end();

        assertEquals(lineSeparator() + "primitive: 1", this.getResult());
    }

    @Test
    public void shouldCorrectlySaveWhenAutoFlush() throws LoggerException, IOException {
        LoggerFacade.log("test string 1");
        LoggerFacade.log(1);
        LoggerFacade.log((byte) 0);
        LoggerFacade.end();

        assertEquals(lineSeparator() +
                "string: test string 1" + lineSeparator() +
                "primitive: 1" + lineSeparator() +
                "primitive: 0", this.getResult());
    }
}
