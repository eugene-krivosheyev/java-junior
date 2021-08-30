package com.db.edu.utest;

import com.db.edu.Controller;
import com.db.edu.saver.ConsoleSaver;
import com.db.edu.saver.Saver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ControllerTest {

    @Test
    void shouldThrowExceptionWhenMessageIsNull() {
        Saver saverMock = mock(Saver.class);
        Controller controller = new Controller(saverMock);
        assertThrows(NullPointerException.class, () -> controller.log(null), "Message shouldn't be null");
    }
}