package com.acme.edu.model;

import com.acme.edu.model.message.Message;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MessageContainerTest {

    @Test
    public void shouldFlushWhenDifferentTypeMessage(){
        Message lastMessage = Mockito.mock(Message.class);
        Message newMessage = Mockito.mock(Message.class);

        when(lastMessage.canAccumulateMessage(any())).thenReturn(false);

        final MessageContainer containerSut = new MessageContainer();
        containerSut.addMessage(lastMessage);
        containerSut.addMessage(newMessage);

        verify(lastMessage).canAccumulateMessage(any());
    }
}
