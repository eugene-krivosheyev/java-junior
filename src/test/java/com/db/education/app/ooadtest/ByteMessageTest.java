package com.db.education.app.ooadtest;

import com.db.education.app.message.ByteMessage;
import com.db.education.app.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.db.education.app.ooadtest.AccumulatableMessageTestHelper.*;
import static com.db.education.app.ooadtest.PrimitiveMessageTestHelper.runBasicDecorationTest;

public class ByteMessageTest {

    private String prefix = "primitive: ";
    private byte body = (byte) 1;
    private Message messageOne;

    @BeforeEach
    public void setUp() {
        messageOne = new ByteMessage(body);
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
    public void shouldAccumulateBytesWhenReceived() {
        byte body2 = (byte) 5;
        runAccumulationNoOverflowTest(messageOne, new ByteMessage(body2), prefix, (byte) 6);
    }

    @Test
    public void shouldCorrectlyLogOverflowBytesWhenReceived() {
        byte body2 = Byte.MAX_VALUE;
        runAccumulationOverflowTest(messageOne, new ByteMessage(body2), prefix, body, body2);
    }
}
