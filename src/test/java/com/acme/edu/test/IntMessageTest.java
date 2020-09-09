package com.acme.edu.test;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;

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
    public void shouldBeSameTypeWhenCallIsSameTypeMethod() {
        IntMessage intMock = mock(IntMessage.class);
        StringMessage stringMock = mock(StringMessage.class);

        final boolean trueBoolean = sut.isSameType(intMock);
        final boolean falseBoolean = sut.isSameType(stringMock);

        assertThat(trueBoolean).isTrue();
        assertThat(falseBoolean).isFalse();

    }


}
