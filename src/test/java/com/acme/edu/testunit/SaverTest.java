package com.acme.edu.testunit;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.exceptions.FileSaverException;
import com.acme.edu.savers.FileSaver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class SaverTest implements SysoutCaptureAndAssertionAbility {
    static final FileSaver fileSut = new FileSaver("results.txt", "Windows-1251");

    @Test
    public void shouldLogInFile() throws IOException {
        fileSut.save("Message add");
        Path testFile = Paths.get("results.txt");
        List<String> lines = Files.readAllLines(testFile);
        assertThat("Error while writing to file",
                lines.get(lines.size()-1).equals("Message add"));

    }
}
