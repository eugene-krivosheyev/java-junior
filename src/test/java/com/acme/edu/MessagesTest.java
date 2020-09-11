package com.acme.edu;

import com.acme.edu.message.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessagesTest implements SysoutCaptureAndAssertionAbility {
    private final IntMessage intMessage = new IntMessage(0);
    private final CharMessage charMessage = new CharMessage('a');
    private final BoolMessage boolMessage = new BoolMessage(true);
    private final StringMessage strMessage = new StringMessage("");
    private final ByteMessage byteMessage = new ByteMessage((byte) 1);
    private final ArrayMessage arrayMessage = new ArrayMessage(new int[] {0});
    private final MatrixMessage matrixMessage = new MatrixMessage(new int[][] {{0}});
    private final ReferenceMessage referenceMessage = new ReferenceMessage(new Object());
    private final MultiMatrixMessage multiMatrixMessage = new MultiMatrixMessage(new int[][][][] {{{{0}}}});

    @Before
    public void setUp() {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    //region Different types tests
    @Test
    public void shouldSayNotSameTypeWhenIntAndStringMessagesProvided() {
        boolean result = intMessage.isSameType(strMessage);
        assertFalse(result);
    }

    @Test
    public void shouldSayNotSameTypeWhenIntAndArrayMessagesProvided() {
        boolean result = arrayMessage.isSameType(intMessage);
        assertFalse(result);
    }

    @Test
    public void shouldSayNotSameTypeWhenArrayAndMatrixMessagesProvided() {
        boolean result = matrixMessage.isSameType(arrayMessage);
        assertFalse(result);
    }

    @Test
    public void shouldSayNotSameTypeWhenIntAndCharProvided() {
        boolean result = charMessage.isSameType(intMessage);
        assertFalse(result);
    }

    @Test
    public void shouldSayNotSameTypeWhenRefAndCharProvided() {
        boolean result = referenceMessage.isSameType(charMessage);
        assertFalse(result);
    }

    @Test
    public void shouldSayNotSameTypeWhenByteAndCharProvided() {
        boolean result = byteMessage.isSameType(charMessage);
        assertFalse(result);
    }

    @Test
    public void shouldSayNotSameTypeWhenBoolAndStringProvided() {
        boolean result = boolMessage.isSameType(arrayMessage);
        assertFalse(result);
    }

    @Test
    public void shouldSayNotSameTypeWhenMultiMatrixAndMatrixProvided() {
        boolean result = multiMatrixMessage.isSameType(matrixMessage);
        assertFalse(result);
    }
    //endregion

    //region Same type tests
    @Test
    public void shouldSayIsSameTypeWhenStrsProvided() {
        boolean result = strMessage.isSameType(strMessage);
        assertTrue(result);
    }

    @Test
    public void shouldSayIsSameTypeWhenBoolsProvided() {
        boolean result = boolMessage.isSameType(boolMessage);
        assertTrue(result);
    }

    @Test
    public void shouldSayIsSameTypeWhenCharsProvided() {
        boolean result = charMessage.isSameType(charMessage);
        assertTrue(result);
    }

    @Test
    public void shouldSayIsSameTypeWhenArraysProvided() {
        boolean result = arrayMessage.isSameType(arrayMessage);
        assertTrue(result);
    }

    @Test
    public void shouldSayIsSameTypeWhenInsProvided() {
        boolean result = intMessage.isSameType(intMessage);
        assertTrue(result);
    }

    @Test
    public void shouldSayIsSameTypeWhenMatrixesProvided() {
        boolean result = matrixMessage.isSameType(matrixMessage);
        assertTrue(result);
    }

    @Test
    public void shouldSayIsSameTypeWhenRefsProvided() {
        boolean result = referenceMessage.isSameType(referenceMessage);
        assertTrue(result);
    }

    @Test
    public void shouldSayIsSameTypeWhenBytesProvided() {
        boolean result = byteMessage.isSameType(byteMessage);
        assertTrue(result);
    }

    @Test
    public void shouldSayIsSameTypeWhenMultiMatrixesProvided() {
        boolean result = multiMatrixMessage.isSameType(multiMatrixMessage);
        assertTrue(result);
    }
    //endregion
}
