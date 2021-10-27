package com.acme.edu.messages;

import com.acme.edu.LoggerController;
import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;
import com.acme.edu.messages.IntMessage;
import com.acme.edu.messages.StringMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class StringMessageTest {

    private StringMessage defaultMessage;
    private StringMessage sameValueMessage;
    private StringMessage differentValueMessage;
    private StringMessage accumulatedDefaultMessage;
    private IntMessage anotherTypeMessage;

    private String DEFAULT_VALUE;
    private String DIFFERENT_VALUE;

    @BeforeEach
    public void TestsPreparation() {
        DEFAULT_VALUE = "default str";
        DIFFERENT_VALUE = "another str";

        defaultMessage = new StringMessage(DEFAULT_VALUE);
        sameValueMessage = new StringMessage(DEFAULT_VALUE);
        differentValueMessage = new StringMessage(DIFFERENT_VALUE);
        accumulatedDefaultMessage = new StringMessage(DEFAULT_VALUE, 2);
        anotherTypeMessage = new IntMessage(1);

    }

    @Test
    public void shouldThrowExceptionWhenAccumulateWithAnotherType() {
        // Then
        assertThrows(IllegalArgumentException.class,
                () -> defaultMessage.accumulate(anotherTypeMessage));
    }
    @Test
    public void shouldReturnPreviousMessageWhenAccumulateDifferentValue() {
        // When
        Message actualMessage = defaultMessage.accumulate(differentValueMessage);

        // Then
        StringMessage expectedMessage = new StringMessage(DIFFERENT_VALUE);
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void shouldReturnNullWhenAccumulateSameValue() {
        // When
        Message actualMessage = defaultMessage.accumulate(sameValueMessage);

        // Then
        StringMessage expectedFirstMessage = new StringMessage(DEFAULT_VALUE, 2);
        StringMessage expectedSecondMessage = null;

        assertEquals(expectedFirstMessage, defaultMessage);
        assertEquals(expectedSecondMessage, actualMessage);
    }

    @Test
    public void shouldReturnDecoratedString() {
        // When
        String actual = defaultMessage.getDecoratedString();

        // Then
        String expected = "string: " + DEFAULT_VALUE;
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnDecoratedStringWithPostfixWhenAccumulatedMessage() {
        // Given
        StringMessage firstMessage = new StringMessage(DEFAULT_VALUE, 3);

        // When
        String actual = firstMessage.getDecoratedString();

        // Then
        String expected = "string: " + DEFAULT_VALUE + " (x3)";
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnTrueWhenSameType() {
        // When
        boolean actual1 = defaultMessage.isSameType(differentValueMessage);
        boolean actual2 = differentValueMessage.isSameType(defaultMessage);

        // Then
        boolean expected = true;
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }

    @Test
    public void shouldReturnTrueWhenEqualObjects() {
        // Given
        StringMessage firstMessage = new StringMessage("default str", 2);
        StringMessage secondMessage = new StringMessage("default str", 2);

        // When
        boolean actual1 = firstMessage.equals(secondMessage);
        boolean actual2 = secondMessage.equals(firstMessage);

        // Then
        boolean expected = true;
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }
    @Test
    public void shouldReturnFalseWhenDifferentValue() {
        // When
        boolean actual1 = defaultMessage.equals(differentValueMessage);
        boolean actual2 = differentValueMessage.equals(defaultMessage);

        // Then
        boolean expected = false;
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }
    @Test
    public void shouldReturnFalseWhenDifferentCounter() {
        // When
        boolean actual1 = defaultMessage.equals(accumulatedDefaultMessage);
        boolean actual2 = accumulatedDefaultMessage.equals(defaultMessage);

        // Then
        boolean expected = false;
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }

    @Test
    public void shouldReturnFalseWhenCalledEqualsWithDifferentType() {
        // When
        boolean actual = defaultMessage.equals(anotherTypeMessage);

        boolean expected = false;
        assertEquals(actual, expected);
    }

}
