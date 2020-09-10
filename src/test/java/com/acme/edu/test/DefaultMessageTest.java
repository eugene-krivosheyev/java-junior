package com.acme.edu.test;

import com.acme.edu.message.DefaultMessage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultMessageTest {
    private DefaultMessage sut;

    @Before
    public void setUp() {
        sut = new DefaultMessage();
    }

    @Test
    public void shouldReturnEmptyStringWhenGetMessage(){
        assertEquals(sut.getMessage(), "");
    }

}
