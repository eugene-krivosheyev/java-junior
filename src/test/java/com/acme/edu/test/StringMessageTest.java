package com.acme.edu.test;

import com.acme.edu.SysoutCaptureAndAssertionAbility;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.LoggerMessage;
import com.acme.edu.message.StringMessage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.fest.assertions.Assertions.assertThat;

public class StringMessageTest implements SysoutCaptureAndAssertionAbility {
    private LoggerMessage sut;

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
    public void isNotOverflowedShouldAlwaysReturnTrue() {
        assertTrue(sut.isNotOverflowed(new IntMessage(3)));
    }
}
