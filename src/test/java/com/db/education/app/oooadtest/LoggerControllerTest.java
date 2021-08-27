package com.db.education.app.oooadtest;

import com.db.education.app.controller.LoggerController;
import com.db.education.app.message.ByteMessage;
import com.db.education.app.message.EmptyMessage;
import com.db.education.app.message.Message;
import com.db.education.app.message.StringMessage;
import com.db.education.app.saver.Saver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoggerControllerTest {

    private LoggerController controllerSut;
    private Saver saverDummy;

    @BeforeEach
    public void setUpSystemOut() throws IOException {
        saverDummy = mock(Saver.class);
        controllerSut = new LoggerController(saverDummy);
    }

    @Test
    public void shouldGetErrorWhenMessageIsEmpty() {
        Message emptyMessage = mock(EmptyMessage.class);
        when(emptyMessage.isEmpty()).thenReturn(true);

        assertThrows(
                IllegalArgumentException.class,
                () -> controllerSut.processMessage(emptyMessage)
        );
    }

    @Test
    public void shouldGetErrorWhenNoMessageProvided() {
        Message noMessage = null;

        assertThrows(
                IllegalArgumentException.class,
                () -> controllerSut.processMessage(noMessage)
        );
    }

    @Test
    public void shouldUpdateWhenFirstMessageProvided() {
        Message byteMessageDummy = mock(ByteMessage.class);

        controllerSut.processMessage(byteMessageDummy);
        controllerSut.flush();

        verify(saverDummy).save(byteMessageDummy);
    }

    @Test
    public void shouldAccumulateStringsWhenStringMessageProvided() {
        ArgumentCaptor<Message> messageCaptor = ArgumentCaptor.forClass(StringMessage.class);
        Message stringMessageDummyFirst = new StringMessage("first");
        Message stringMessageDummySecond = new StringMessage("first");

        controllerSut.processMessage(stringMessageDummyFirst);
        controllerSut.processMessage(stringMessageDummySecond);
        controllerSut.flush();

        String expected = "string: first (x2)" + System.lineSeparator();
        verify(saverDummy).save(messageCaptor.capture());
        assertEquals(expected, messageCaptor.getValue().toString());
    }

    @Test
    public void shouldAccumulateBytesWhenByteMessageProvided() {
        ArgumentCaptor<Message> messageCaptor = ArgumentCaptor.forClass(ByteMessage.class);
        Message byteMessageDummyFirst = new ByteMessage((byte) 1);
        Message byteMessageDummySecond = new ByteMessage((byte) 1);

        controllerSut.processMessage(byteMessageDummyFirst);
        controllerSut.processMessage(byteMessageDummySecond);
        controllerSut.flush();

        String expected = "primitive: 2" + System.lineSeparator();
        verify(saverDummy).save(messageCaptor.capture());
        assertEquals(expected, messageCaptor.getValue().toString());
    }
}
