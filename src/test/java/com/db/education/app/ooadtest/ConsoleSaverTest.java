package com.db.education.app.ooadtest;

import com.db.education.app.SysoutCaptureAndAssertionAbility;
import com.db.education.app.exception.SaveException;
import com.db.education.app.message.Message;
import com.db.education.app.saver.ConsoleSaver;
import com.db.education.app.saver.Saver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConsoleSaverTest implements SysoutCaptureAndAssertionAbility {

    private Saver saverSut;

    @BeforeEach
    public void setUp() {
        saverSut = new ConsoleSaver();
        tearDown();
        captureSysout();
    }

    @AfterEach
    public void tearDown() {
        resetOut();
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
    public void shouldPrintToConsoleWhenMessageProvided() throws SaveException {
        String expected = "primitive: 1";
        Message messageDummy = mock(Message.class);
        when(messageDummy.toString()).thenReturn(expected);

        saverSut.save(messageDummy);

        assertSysoutEquals(expected);
    }
}
