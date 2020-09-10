package com.acme.edu.test;

import com.acme.edu.SysoutCaptureAndAssertionAbility;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.LoggerMessage;
import com.acme.edu.message.StringMessage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class StringMessageTest implements SysoutCaptureAndAssertionAbility {
    private StringMessage sut;

    @Before
    public void setUp(){
        sut = new StringMessage("test");
    }


    @Test
    public void shouldBeSameTypeWithItself(){
        assertTrue(sut.isSameType(sut));
    }

    @Test
    public void shouldBeSameTypeWithStringMessage(){
        StringMessage mess = new StringMessage("me");

        assertTrue(sut.isSameType(mess));
    }

    @Test
    public void shouldNotBeSameTypeWithIntMessage(){
        IntMessage mess = new IntMessage(6);

        assertFalse(sut.isSameType(mess));
    }

    @Test
    public void getMessageShouldReturnRightString() {
        String mess = sut.getMessage();

        assertThat(mess).isEqualTo("string: test");
    }

    @Test
    public void shouldAppendMessageWhenAccumulateStringMessageWithNotSameMessage(){
        StringMessage dummyMessage = spy(new StringMessage("test 1"));
        sut = spy(new StringMessage("test 2"));

        assertEquals(sut.accumulate(dummyMessage).getMessage(),"string: test 2 test 1");
    }

    @Test
    public void shouldIncreaseCounterWhenAccumulateStringMessageWithSameMessage(){
        StringMessage dummyMessage = spy(new StringMessage("test 1"));
        sut = spy(new StringMessage("test 1"));

        assertEquals(sut.accumulate(dummyMessage).getMessage(),"string: test 1 (x2)"+ lineSeparator());
    }
}
