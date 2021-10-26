package com.acme.edu.unitTests;

import com.acme.edu.model.MessageContainer;
import com.acme.edu.model.message.Message;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MessageContainerTest {

    @Test
    public void shouldFlushWhenDifferentTypeMessage(){
        Message lastMessage = Mockito.mock(Message.class);

        when(lastMessage.canJoinMessage(any())).thenReturn(false);

        final MessageContainer containerSut = new MessageContainer(lastMessage);
        containerSut.addMessage(lastMessage);

        verify(lastMessage).canJoinMessage(any());
    }
}
