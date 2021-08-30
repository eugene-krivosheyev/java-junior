package com.acme.edu.unit;

import com.acme.edu.LoggerController;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.SaveException;
import com.acme.edu.saver.Saver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class LoggerControllerTest implements SysoutCaptureAndAssertionAbility {
    private LoggerController controllerSut;
    private Saver saverDummy;

    //region given
    @BeforeEach
    void setup() {
        saverDummy = mock(ConsoleSaver.class);
        controllerSut = new LoggerController(saverDummy);
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldAccumulateWhenMessageTypeIsNotChanged() throws SaveException {
        IntMessage intMessage = mock(IntMessage.class);
        when(intMessage.sameTypeOf(any())).thenReturn(true);

        //when
        controllerSut.log(intMessage);
        controllerSut.log(intMessage);

        //then
        verify(intMessage, times(1)).accumulate(any());
    }

    @Test
    public void shouldSaveWhenMessageTypeChanged() throws SaveException {
        Message message = mock(Message.class);
        when(message.sameTypeOf(any())).thenReturn(false);
        when(message.getDecoratedMessage()).thenReturn("emptyMessage");

        //when
        controllerSut.log(message);
        controllerSut.log(message);

        //then
        verify(saverDummy, times(1)).save(any());
    }

    @Test
    public void shouldNotSaveWhenMessageTypeChangedAndDecorateIsNull() throws SaveException {
        Message message = mock(Message.class);
        when(message.sameTypeOf(any())).thenReturn(false);
        when(message.getDecoratedMessage()).thenReturn(null);

        //when
        controllerSut.log(message);
        controllerSut.log(message);

        //then
        verify(saverDummy, times(0)).save(any());
    }
}