package com.acme.edu.test;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

public class IntMessageTest {
    private IntMessage sut;

    @Before
    public void setUp() {
        sut = new IntMessage(3);
    }

    @Test
    public void shouldPrintPrimitivePrefixWhenGetMessage() {
        String message = sut.getMessage();

        assertThat(message).isEqualTo("primitive: 3");
    }

    @Test
    public void shouldBeSameTypeWithItself(){
        assertTrue(sut.isSameType(sut));
    }

    @Test
    public void shouldNotBeSameTypeWithStringMessage(){
        StringMessage mess = new StringMessage("me");

        assertFalse(sut.isSameType(mess));
    }

    @Test
    public void shouldBeSameTypeWithIntMessage(){
        IntMessage mess = new IntMessage(6);

        assertTrue(sut.isSameType(mess));
    }
    @Ignore
    @Test
    public void shouldBeSameTypeWhenCallIsSameTypeMethod() {
        IntMessage intMock = mock(IntMessage.class);
        StringMessage stringMock = mock(StringMessage.class);

        final boolean trueBoolean = sut.isSameType(intMock);
        final boolean falseBoolean = sut.isSameType(stringMock);

        assertThat(trueBoolean).isTrue();
        assertThat(falseBoolean).isFalse();

    }

    @Test
    public void shouldSumMessagesWhenAccumulateIntMessage(){
        IntMessage dummyMessage = spy(new IntMessage(3));
        sut = spy(new IntMessage(2));

        assertEquals(sut.accumulate(dummyMessage).getMessage(),"primitive: 5");
    }

    @Test
    public void shouldReturnFalseWhenOverFlowed(){
        IntMessage dummyMessage = spy(new IntMessage(Integer.MAX_VALUE));
        sut = spy(new IntMessage(2));

        assertFalse(sut.isNotOverflowed(dummyMessage));
    }

    @Test
    public void shouldReturnTrueWhenNotOverFlowed(){
        IntMessage dummyMessage = spy(new IntMessage(5));
        sut = spy(new IntMessage(2));

        assertTrue(sut.isNotOverflowed(dummyMessage));
    }
}
