package com.acme.edu.unit;

import com.acme.edu.LoggerController;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.message.EmptyMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.Saver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoggerControllerTest implements SysoutCaptureAndAssertionAbility {
    private LoggerController controllerSud;
    private Saver saverMock;

    //region given
    @BeforeEach
    void setup() {
        saverMock = new ConsoleSaver();
        controllerSud = new LoggerController(saverMock);
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldReturnFalseWhenComparingEmptyMessage() {
        EmptyMessage emptyMessage = mock(EmptyMessage.class);
        IntMessage intMessage = mock(IntMessage.class);


        assertFalse(emptyMessage.sameTypeOf(intMessage), "Should return false when comparing empty message");
    }

    @Test
    public void shouldSaveMessage() {

    }
}