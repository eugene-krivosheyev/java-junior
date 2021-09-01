package com.db.edu.unitTest.SaverTest;

import com.db.edu.Message.Message;
import com.db.edu.Save.ConsoleSaver;
import com.db.edu.Save.SaveException;
import com.db.edu.Save.Saver;
import com.db.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class ConsoleSaverTest implements SysoutCaptureAndAssertionAbility {

    @BeforeEach
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @Test
    public void saveMessageWhenRegularMessageGiven() throws SaveException {
        Message messageMock = mock(Message.class);
        when(messageMock.decorate()).thenReturn("Message string with prefix");

        Saver saver = new ConsoleSaver();
        saver.save(messageMock.decorate());

        verify(messageMock, times(1)).decorate();
        assertSysoutContains("Message string with prefix");

    }
}
