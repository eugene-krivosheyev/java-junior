package com.db.education.app.ooadtest;

import com.db.education.app.message.Message;
import com.db.education.app.message.StringMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.db.education.app.ooadtest.AccumulatableMessageTestHelper.runDifferentMessageTypeTest;
import static com.db.education.app.ooadtest.PrimitiveMessageTestHelper.runBasicDecorationTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringMessageTest {

    private String prefix = "string: ";
    private String body = "string one";
    private Message messageOne;

    @BeforeEach
    public void setUp() {
        messageOne = new StringMessage(body);
    }

    @Test
    public void shouldDecorateMessageProperlyWhenNotAccumulated() {
        runBasicDecorationTest(messageOne, prefix, body);
    }

    @Test
    public void shouldFlushAndNotAccumulateWhenReceivedMessageTypeDiffers() {
        runDifferentMessageTypeTest(messageOne);
    }

    @Test
    public void shouldFlushAndNotAccumulateWhenReceivedStringMessageBodyDiffers() {
        Message stringMessageTwo = new StringMessage("string two");
        boolean expectedFlushStatus = true;
        String expectedMessage = messageOne.toString();

        String actualMessage = messageOne.accumulate(stringMessageTwo).toString();
        boolean actualFlushStatus = messageOne.needsFlush();

        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedFlushStatus, actualFlushStatus);
    }

    @Test
    public void shouldAccumulateAndDecorateProperlyWhenReceivedStringMessageBodyEquals() {
        Message stringMessageTwo = new StringMessage(body);
        Message stringMessageThree = new StringMessage(body);
        boolean expectedFlushStatus = false;
        String expectedMessage = prefix + body + " (x3)" + System.lineSeparator();

        messageOne.accumulate(stringMessageTwo);
        messageOne.accumulate(stringMessageThree);
        String actualMessage = messageOne.toString();
        boolean actualFlushStatus = messageOne.needsFlush();

        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedFlushStatus, actualFlushStatus);
    }
}
