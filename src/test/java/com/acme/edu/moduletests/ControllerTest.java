package com.acme.edu.moduletests;

import com.acme.edu.controller.Controller;
import com.acme.edu.decorator.Decorator;
import com.acme.edu.message.Message;
import com.acme.edu.message.MessageType;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.mockito.Mockito.*;

public class ControllerTest {
    private Controller sut;

    @Before
    public void setUp() {
        sut = new Controller();
    }

    @Test
    public void shouldAccumulateMessageWhenAccumulatable() {
        //region Given
        Message mockMessage = mock(Message.class);
        Message mockPrevMessage = mock(Message.class);
        when(mockPrevMessage.isAbleToAccumulate(mockMessage)).thenReturn(true);
        //endregion

        //region When
        sut.log(mockPrevMessage);
        sut.log(mockMessage);
        //endregion

        //region Then
        verify(mockPrevMessage, times(1)).isAbleToAccumulate(mockMessage);
        verify(mockPrevMessage, times(1)).accumulate(mockMessage);
        //endregion
    }

    @Test
    public void shouldDecorateMessageWhenNotAccumulatable() {
        //region Given
        Message mockMessage = mock(Message.class);
        Message mockPrevMessage = mock(Message.class);
        when(mockPrevMessage.isAbleToAccumulate(mockMessage)).thenReturn(false);
        when(mockPrevMessage.decorate(any(Map.class))).thenReturn("primitive: 42");
        //endregion

        //region When
        sut.log(mockPrevMessage);
        sut.log(mockMessage);
        //endregion

        //region Then
        verify(mockPrevMessage, times(1)).isAbleToAccumulate(mockMessage);
        verify(mockPrevMessage, times(1)).decorate(any(Map.class));
        //endregion
    }
}
