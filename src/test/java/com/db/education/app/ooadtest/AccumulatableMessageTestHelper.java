package com.db.education.app.ooadtest;

import com.db.education.app.message.BooleanMessage;
import com.db.education.app.message.Message;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccumulatableMessageTestHelper {

    public static void runDifferentMessageTypeTest(Message message) {
        Message booleanMessageDummy = mock(BooleanMessage.class);
        when(booleanMessageDummy.getType()).thenReturn("BOOL");
        boolean expectedFlushStatus = true;
        Message expectedMessage = message;
        String expectedStringMessage = message.toString();

        Message actualMessage = message.accumulate(booleanMessageDummy);
        String actualStringMessage = actualMessage.toString();
        boolean actualFlushStatus = message.needsFlush();

        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedStringMessage, actualStringMessage);
        assertEquals(expectedFlushStatus, actualFlushStatus);
    }

    public static void runAccumulationNoOverflowTest(Message message1, Message message2, String prefix, Object body) {
        boolean expectedFlushStatus = false;
        String expectedMessage = prefix + body + System.lineSeparator();

        message1.accumulate(message2);
        String actualMessage = message1.toString();
        boolean actualFlushStatus = message1.needsFlush();

        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedFlushStatus, actualFlushStatus);
    }

    public static void runAccumulationOverflowTest(Message message1, Message message2, String prefix,
                                                   Object body2, Object body) {
        boolean expectedFlushStatus = true;
        String expectedFirstMessage = prefix + body + System.lineSeparator();
        String expectedSecondMessage = prefix + body2 + System.lineSeparator();

        message1.accumulate(message2);
        String actualFirstMessage = message1.toString();
        String actualSecondMessage = message2.toString();
        boolean actualFlushStatus = message1.needsFlush();

        assertEquals(expectedFirstMessage, actualFirstMessage);
        assertEquals(expectedSecondMessage, actualSecondMessage);
        assertEquals(expectedFlushStatus, actualFlushStatus);
    }
}
