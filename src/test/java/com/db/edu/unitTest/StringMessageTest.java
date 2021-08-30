package com.db.edu.unitTest;

import com.db.edu.Message.*;
import com.db.edu.Prefix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

public class StringMessageTest {
    @Test
    public void getValuesFromStringMessage(){
        Message message = new StringMessage("Message body");

        assertEquals("Message body", message.getValue());
    }

    @Test
    public void getDecoratedStringFromStringMessage(){
        Message message = new StringMessage("Message body");

        assertEquals(Prefix.STRING.value+"Message body", message.decorate());
    }

    @Test
    public void accumulationCheckForSameStringMessage() throws ClassCastException{
        Message message1 = new StringMessage("Message body");
        Message message2 = new StringMessage("Message body");

        message1.accumulate(message2);
        assertEquals("Message body", message1.getValue());
        assertEquals(2, ((StringMessage) message1).getStringCount());
    }

    @Test
    public  void accumulationCheckForOtherStringMessage() throws ClassCastException{
        Message message1 = new StringMessage("Message body");
        Message message2 = new StringMessage("Body Message");

        message1.accumulate(message2);
        assertEquals("Body Message", message1.getValue());
        assertEquals(1, ((StringMessage) message1).getStringCount());
    }

    @Test
    public void comparingStringMessageWithOtherMessageTypes(){
        Message message1 = new StringMessage("Message body");
        Message message2 = mock(IntMessage.class);
        Message message3 = mock(ByteMessage.class);
        Message message4 = mock(CharMessage.class);
        Message message5 = mock(ObjectMessage.class);
        Message message6 = mock(BoolMessage.class);

        assertFalse(message1.typeEquals(message2));
        assertFalse(message1.typeEquals(message3));
        assertFalse(message1.typeEquals(message4));
        assertFalse(message1.typeEquals(message5));
        assertFalse(message1.typeEquals(message6));
    }

    @Test
    public void messageBodyAndStringCountAfterClose(){
        Message message = new StringMessage("Message body");
        message.close();

        assertEquals("", message.getValue());
        assertEquals(0, ((StringMessage) message).getStringCount());
    }
}
