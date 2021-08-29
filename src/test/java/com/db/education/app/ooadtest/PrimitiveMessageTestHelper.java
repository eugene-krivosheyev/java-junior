package com.db.education.app.ooadtest;

import com.db.education.app.message.Message;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimitiveMessageTestHelper {

    public static void runBasicDecorationTest(Message message, String prefix, Object body) {
        String expected = prefix + body + System.lineSeparator();

        Message testMessage = message;
        String actual = testMessage.toString();

        assertEquals(expected, actual);
    }

    public static void runFlushAndAccumulateTest(Message message1, Message message2, String prefix, Object body) {
        Message messageOne = message1;
        Message messageTwo = message2;
        String expectedMessageString = prefix + body + System.lineSeparator();
        Message expectedMessage = messageOne;
        boolean expectedFlushStatus = true;

        Message actualMessage = messageOne.accumulate(messageTwo);
        boolean actualFlushStatus = messageOne.needsFlush();
        String actualMessageString = messageOne.toString();

        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedMessageString, actualMessageString);
        assertEquals(expectedFlushStatus, actualFlushStatus);
    }
}
