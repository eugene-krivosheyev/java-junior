package com.db.edu.unit;

import com.db.edu.Controller;
import com.db.edu.messagepack.message.Message;
import com.db.edu.saver.Saver;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {
    @Test
    public void shouldSavePreviousMessageWhenTypeChanges() {
        Saver saverStub = mock(Saver.class);
        Message previousMessageStub = mock(Message.class);
        Message messageStub = mock(Message.class);

        when(previousMessageStub.isSameType(messageStub)).thenReturn(false);

        Controller sutController = new Controller(saverStub);
        sutController.log(previousMessageStub);
        sutController.log(messageStub);

        verify(saverStub,times(1)).save(previousMessageStub);
    }

    @Test
    public void shouldSaveMessagesOnceWhenTypeNotChangesAndLoggingStops() {
        Saver saverStub = mock(Saver.class);
        Message previousMessageStub = mock(Message.class);
        Message messageStub = mock(Message.class);

        when(previousMessageStub.isSameType(messageStub)).thenReturn(true);
        when(previousMessageStub.accumulate(messageStub)).thenReturn(previousMessageStub);

        Controller sutController = new Controller(saverStub);
        sutController.log(previousMessageStub);
        sutController.log(messageStub);
        sutController.flush();

        verify(saverStub,times(1)).save(previousMessageStub);
    }

    @Test
    public void shouldSaveNothingWhenTypeNotChangesAndLoggingNotStops() {
        Saver saverStub = mock(Saver.class);
        Message previousMessageStub = mock(Message.class);
        Message messageStub = mock(Message.class);

        when(previousMessageStub.isSameType(messageStub)).thenReturn(true);
        when(previousMessageStub.accumulate(messageStub)).thenReturn(previousMessageStub);

        Controller sutController = new Controller(saverStub);
        sutController.log(previousMessageStub);
        sutController.log(messageStub);

        verify(saverStub,never()).save(previousMessageStub);
    }

}
