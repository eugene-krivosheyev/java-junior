package com.db.edu.unitTest;

import com.db.edu.Controller;
import com.db.edu.message.IntMessage;
import com.db.edu.message.StringMessage;
import com.db.edu.save.ConsoleSaver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControllerTest {

    @Test
    public void weCanLogStringWithoutSaving() {
        ConsoleSaver consoleSaverMock = mock(ConsoleSaver.class);
        StringMessage stringMessageMock = mock(StringMessage.class);

        Controller controller = new Controller(consoleSaverMock);
        controller.log(stringMessageMock);

        verify(consoleSaverMock, times(0)).save(anyString());
        assertEquals(controller.getBuffer(), stringMessageMock);
    }

    @Test
    public void weCanLogStringWithSavingMock() {
        ConsoleSaver consoleSaverMock = mock(ConsoleSaver.class);
        StringMessage stringMessage = new StringMessage("value");
        IntMessage intMessage = new IntMessage(1);

        Controller controller = new Controller(consoleSaverMock);
        controller.log(intMessage);
        controller.log(stringMessage);

        verify(consoleSaverMock, times(1)).save(anyString());
        assertEquals(controller.getBuffer(), stringMessage);
    }

    @Test
    public void weCanUseFlushToCleanBuffer() {
        ConsoleSaver consoleSaverMock = mock(ConsoleSaver.class);

        Controller controller = new Controller(consoleSaverMock);
        controller.flush();

        Assertions.assertFalse(controller.getBuffer().isNotEmpty());
    }
}
