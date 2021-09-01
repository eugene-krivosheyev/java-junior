package com.db.edu.unit;

import com.db.edu.messagepack.message.IntMessage;
import com.db.edu.messagepack.message.Message;
import com.db.edu.saver.ConsoleSaver;
import com.db.edu.saver.FileSaver;
import com.db.edu.saver.SaveException;
import com.db.edu.saver.Saver;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaverTest {
    @Test
    public void consoleSaverShouldThrowExceptionWhenMessageIsEmpty() {
        Saver sutConsoleSaver = new ConsoleSaver();

        assertThrows(IllegalArgumentException.class, () -> sutConsoleSaver.save(null));
    }

    @Test
    public void fileSaverShouldThrowExceptionWhenMessageIsEmpty() {
        Saver sutFileSaver = new FileSaver();

        assertThrows(IllegalArgumentException.class, () -> sutFileSaver.save(null));
    }


    @Test
    public void fileSaverShouldSaveCorrectlyWhenIntMessageReceived() throws SaveException, IOException {
        Saver sutFileSaver = new FileSaver();
        Message stubIntMessage = mock(IntMessage.class);

        when(stubIntMessage.getDecoratedMessage()).thenReturn("primitive: 17");
        sutFileSaver.save(new IntMessage(17));
        Path pathToStub = Paths.get("log.txt");

        assertEquals(stubIntMessage.getDecoratedMessage() + System.lineSeparator(), Files.readString(pathToStub));
    }


}
