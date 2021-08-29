package com.db.education.app.ooadtest;

import com.db.education.app.message.Message;
import com.db.education.app.message.ObjectMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.db.education.app.ooadtest.PrimitiveMessageTestHelper.*;
import static org.mockito.Mockito.mock;

public class ObjectMessageTest {

    private String prefix = "reference: ";
    private Object body = mock(Object.class);
    private Message messageOne;

    @BeforeEach
    public void setUp() {
        messageOne = new ObjectMessage(body);
    }

    @Test
    public void shouldDecorateObjectMessageProperly() {
        runBasicDecorationTest(messageOne, prefix, body);
    }

    @Test
    public void shouldFlushAndNotAccumulateWhenDifferentObjectMessagesProvided() {
        Object body2 = mock(Object.class);
        runFlushAndAccumulateTest(messageOne, new ObjectMessage(body2), prefix, body);
    }

    @Test
    public void shouldFlushAndNotAccumulateWhenSameObjectMessagesProvided() {
        runFlushAndAccumulateTest(messageOne, new ObjectMessage(body), prefix, body);
    }
}
