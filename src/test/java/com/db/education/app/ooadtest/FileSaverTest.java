package com.db.education.app.ooadtest;

import com.db.education.app.SysoutCaptureAndAssertionAbility;
import com.db.education.app.exception.SaveException;
import com.db.education.app.message.Message;
import com.db.education.app.saver.ConsoleSaver;
import com.db.education.app.saver.FIleSaver;
import com.db.education.app.saver.Saver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileSaverTest implements SysoutCaptureAndAssertionAbility {

    private Saver saverSut;
    private final String filename = "testLog.log";
    private File file;
    @BeforeEach
    public void setUp() throws IOException {
        file = new File(filename);
        file.createNewFile();
        saverSut = new FIleSaver(filename, 128, "utf-8");
    }
    @AfterEach
    void reset() {
        file.delete();
    }

    @Test
    public void shouldGetErrorWhenNoMessageProvided() {
        Message noMessage = null;

        assertThrows(
                SaveException.class,
                () -> saverSut.save(noMessage)
        );
    }

    @Test
    public void shouldSaveFileWhenLogCorrectMessages() throws SaveException, IOException {
        List<String> expected = new ArrayList<>(2);
        expected.add("primitive: 1" );
        expected.add("string: str");
        Message messageDummy = mock(Message.class);
        when(messageDummy.toString()).thenReturn(expected.get(0) + System.lineSeparator()).thenReturn(expected.get(1) +System.lineSeparator());

        saverSut.save(messageDummy);
        saverSut.save(messageDummy);

        String line;
        List<String> actual = new ArrayList<>(2);
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            while ((line = bufferedReader.readLine()) != null) {
                actual.add(line);
            }
        }
        assertEquals(expected, actual);
    }
}
