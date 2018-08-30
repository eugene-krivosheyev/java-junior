package com.acme.edu.unittests;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;
import com.acme.edu.message.decorator.Decorator;
import com.acme.edu.message.decorator.DefaultDecorator;
import org.junit.Test;

import java.util.Objects;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StringMessageTest {
    private Decorator decorator = mock(DefaultDecorator.class);
    private StringMessage sut = new StringMessage("test", decorator);

    private void assertSutIsSameTypeOf(Message messageToCompareWith) {
        boolean testMethodResult = sut.isSameTypeOf(messageToCompareWith);
        if (!(messageToCompareWith instanceof StringMessage)) {
            assertFalse(testMethodResult);
        }
        else {
            if (Objects.equals(sut.getMessage(), ((StringMessage) messageToCompareWith).getMessage()))
            {
                assertTrue(testMethodResult);
            }
            else
            {
                assertFalse(testMethodResult);
            }
        }
    }

    @Test
    public void isSameTypeOfWithSameString(){
        StringMessage stubMessage = new StringMessage("test", decorator);
        assertSutIsSameTypeOf(stubMessage);
    }

    @Test
    public void isSameTypeOfWithAnotherString(){
        StringMessage stubMessage = new StringMessage("another_test", decorator);
        assertSutIsSameTypeOf(stubMessage);
    }

    @Test
    public void isSameTypeOfWithIntMessage(){
        IntMessage stubMessage = mock(IntMessage.class);
        when(stubMessage.getMessage()).thenReturn(1);
        assertSutIsSameTypeOf(stubMessage);
    }

    @Test
    public void getDecoratedMessageIfCounterEqualsOne(){
        when(decorator.getDecoratedMessage()).thenReturn("string: test");
        String resultingDecoratedMessage = sut.getDecoratedMessage();
        assertEquals(1, sut.getCounter());
        assertEquals("string: test", resultingDecoratedMessage);
    }

    @Test
    public void getDecoratedMessageIfCounterIsMoreThanOne(){
        StringMessage dummyMessage = null;
        Message resultAccumulate = sut.accumulate(dummyMessage);
        when(decorator.getDecoratedMessage()).thenReturn("string: test (x2)");
        String resultingDecoratedMessage = resultAccumulate.getDecoratedMessage();
        assertEquals("string: test (x2)", resultingDecoratedMessage);
    }
}
