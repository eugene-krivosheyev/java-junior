package com.db.edu.unit;

import com.db.edu.Controller;
import com.db.edu.message.Message;
import com.db.edu.save.Saver;
import org.junit.jupiter.api.*;
import com.db.edu.SaverException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControllerTest {

    Saver saverMock = mock(Saver.class);
    Message messageMock = mock(Message.class);
    Controller controller = new Controller(saverMock);

    @Test
    public void weCanLogAnyMessageButItWouldNotBeSaved() throws SaverException {
        when(messageMock.accumulate(any())).thenReturn(messageMock);

        controller.log(messageMock);

        verify(messageMock, times(1)).accumulate(any());
        verify(saverMock, times(0)).save(anyString());
        assertEquals(controller.getBuffer(), messageMock);
    }

    @Test
    public void weCanLogStringWithSavingMock() throws SaverException {
        Message additionalMessageMock = mock(Message.class);
        when(messageMock.accumulate(any())).thenReturn(messageMock);
        when(additionalMessageMock.accumulate(any())).thenReturn(additionalMessageMock);
        when(additionalMessageMock.isStateNotEquals(any(Message.class))).thenReturn(true);
        when(messageMock.isNotEmpty()).thenReturn(true);

        controller.log(messageMock);
        controller.log(additionalMessageMock);

        verify(saverMock, times(1)).save(any());
        assertEquals(controller.getBuffer(), additionalMessageMock);
    }

    @Test
    public void weCanUseFlushToCleanBuffer() {

        controller.flush();

        Assertions.assertFalse(controller.getBuffer().isNotEmpty());
    }
}
