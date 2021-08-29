package com.db.education.app.ooadtest;

import com.db.education.app.message.IntegerMessage;
import com.db.education.app.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.db.education.app.ooadtest.AccumulatableMessageTestHelper.*;
import static com.db.education.app.ooadtest.PrimitiveMessageTestHelper.runBasicDecorationTest;

public class IntegerMessageTest {

    private String prefix = "primitive: ";
    private int body = 1;
    private Message messageOne;

    @BeforeEach
    public void setUp() {
        messageOne = new IntegerMessage(body);
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
    public void shouldAccumulateIntegersWhenReceived() {
        int body2 = 5;
        runAccumulationNoOverflowTest(messageOne, new IntegerMessage(body2), prefix, 6);
    }

    @Test
    public void shouldCorrectlyLogOverflowIntegersWhenReceived() {
        int body2 = Integer.MAX_VALUE;
        runAccumulationOverflowTest(messageOne, new IntegerMessage(body2), prefix, body, body2);
    }
}
