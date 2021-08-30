package com.db.edu.unitTest;

import com.db.edu.Message.*;
import com.db.edu.Prefix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class IntMessageTest {
    @Test
    public void getValuesFromIntMessage(){
        Message message = new IntMessage(8);

        assertEquals(8, Integer.parseInt(message.getValue()));
    }

    @Test
    public void getDecoratedStringFromIntMessage(){
        Message message = new IntMessage(2);

        assertEquals(Prefix.PRIMITIVE.value+"2", message.decorate());
    }

    @Test
    public void accumulationCheckForIntMessage() throws ClassCastException{
        Message message1 = new IntMessage(1);
        Message message2 = new IntMessage(4);

        message1.accumulate(message2);
        assertEquals(5, Integer.parseInt(message1.getValue()));
    }

    @Test
    public void comparingIntMessageWithOtherMessageTypes(){
        Message message1 = new IntMessage(5);
        Message message2 = mock(StringMessage.class);
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
    public void messageBodyAfterClose(){
        Message message = new IntMessage(5);
        message.close();

        assertEquals(Integer.parseInt(message.getValue()), 0);
    }
}
