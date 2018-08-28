package com.acme.edu.unittests;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;
import com.acme.edu.message.decorator.Decorator;
import com.acme.edu.message.decorator.DefaultDecorator;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class StringMessageTest {
    Decorator decorator = mock(DefaultDecorator.class);
    StringMessage sut = new StringMessage("test", decorator);

    public void checkIsSameTypeOf(Message messageToCompareWith, boolean expectedResult) {
        assertEquals(expectedResult, sut.isSameTypeOf(messageToCompareWith));
    }

    @Test
    public void isSameTypeOfWithSameString(){
        checkIsSameTypeOf(new StringMessage("test", decorator), true);
    }

    @Test
    public void isSameTypeOfWithAnotherString(){
        checkIsSameTypeOf(new StringMessage("another_test", decorator), false);
    }

    @Test
    public void isSameTypeOfWithFlushMessage(){
        checkIsSameTypeOf(new IntMessage(1, decorator), false);
    }
}
