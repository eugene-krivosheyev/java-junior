package com.acme.edu.testunit;

import com.acme.edu.LoggerController;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.filters.Filter;
import com.acme.edu.messages.Message;
import com.acme.edu.messages.StringMessage;
import com.acme.edu.savers.Saver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoggerControllerTest implements SysoutCaptureAndAssertionAbility {
    LoggerController controllerSut;

    @BeforeEach
    public void setBasicArguments() {
        Filter filterDummy = mock(Filter.class);
        Saver saveDummy = mock(Saver.class);
        controllerSut = new LoggerController(saveDummy, filterDummy);
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldGiveErrorWhenMessageBodyIsNull() {
        Message nullBodyMessage = mock(Message.class);
        when(nullBodyMessage.getValue()).thenReturn(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> controllerSut.log(nullBodyMessage)
        );
    }

    @Test
    public void shouldGiveErrorWhenMessageBodyIsEmpty() {
        Message emptyMessage = mock(Message.class);
        when(emptyMessage.getValue()).thenReturn("");

        assertThrows(
                IllegalArgumentException.class,
                () -> controllerSut.log(emptyMessage)
        );
    }

    @Test
    public void shouldGiveErrorWhenMessageIsNullReference() {
        Message nullMessage = mock(Message.class);
        when(nullMessage.getValue()).thenReturn(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> controllerSut.log(nullMessage)
        );
    }

}
