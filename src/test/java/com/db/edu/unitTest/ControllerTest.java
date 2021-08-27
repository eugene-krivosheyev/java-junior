package com.db.edu.unitTest;

import com.db.edu.Controller;
import com.db.edu.message.IntMessage;
import com.db.edu.message.StringMessage;
import com.db.edu.save.ConsoleSaver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControllerTest {

    @Test
    public void testLogStringWithoutSaving() {
        ConsoleSaver consoleSaver = mock(ConsoleSaver.class);
        Controller controller = new Controller(consoleSaver);
        StringMessage stringMessage = new StringMessage("value");
        controller.log(stringMessage);
        verify(consoleSaver, times(0)).save(anyString());
        assertEquals(controller.getBuffer(), stringMessage);
    }

    @Test
    public void testLogStringWithSaving() {
        ConsoleSaver consoleSaver = mock(ConsoleSaver.class);
        Controller controller = new Controller(consoleSaver);
        StringMessage stringMessage = new StringMessage("value");
        IntMessage intMessage = new IntMessage(1);
        controller.log(intMessage);
        controller.log(stringMessage);
        verify(consoleSaver, times(1)).save(anyString());
        assertEquals(controller.getBuffer(), stringMessage);
    }

}
