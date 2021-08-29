package com.db.education.app.ooadtest;

import com.db.education.app.message.BooleanMessage;
import com.db.education.app.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.db.education.app.ooadtest.PrimitiveMessageTestHelper.*;

public class BooleanMessageTest {

    private String prefix = "primitive: ";
    private boolean body = true;
    private Message messageOne;

    @BeforeEach
    public void setUp() {
        messageOne = new BooleanMessage(body);
    }

    @Test
    public void shouldDecorateBooleanMessageProperly() {
        runBasicDecorationTest(messageOne, prefix, body);
    }

    @Test
    public void shouldFlushAndNotAccumulateWhenDifferentBooleanMessagesProvided() {
        boolean body2 = false;
        runFlushAndAccumulateTest(messageOne, new BooleanMessage(body2), prefix, body);
    }

    @Test
    public void shouldFlushAndNotAccumulateWhenSameBooleanMessagesProvided() {
        runFlushAndAccumulateTest(messageOne, new BooleanMessage(body), prefix, body);
    }
}
