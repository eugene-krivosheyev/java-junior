package com.acme.edu.IterationTest;

import com.acme.edu.decorator.ClassicDecorator;
import com.acme.edu.decorator.DecoratorVisitor;
import com.acme.edu.message.*;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class OtherTypesMessageTest {
    BooleanMessage booleanMessage = new BooleanMessage(false);
    CharMessage charMessage = new CharMessage((char)32);
    ObjectMessage objectMessage = new ObjectMessage(new Object());
    int[] firstRow = new int[] {1, 2, 3};
    int[] secondRow = new int[] {2, 3, 4};
    IntArrayMessage intArrayMessage = new IntArrayMessage(firstRow);
    IntMatrixMessage intMatrixMessage = new IntMatrixMessage(new int[][] {firstRow, secondRow});

    @Test
    public void shouldAcceptDecoratorGivenBooleanMessage() {
        DecoratorVisitor mock = mock(ClassicDecorator.class);

        booleanMessage.accept(mock);

        verify(mock).decorateBoolean(anyBoolean());
    }

    @Test
    public void shouldAcceptDecoratorGivenCharMessage() {
        DecoratorVisitor mock = mock(ClassicDecorator.class);

        charMessage.accept(mock);

        verify(mock).decorateChar(anyChar());
    }

    @Test
    public void shouldAcceptDecoratorGivenIntArrayMessage() {
        DecoratorVisitor mock = mock(ClassicDecorator.class);

        intArrayMessage.accept(mock);

        verify(mock).decorateIntArray(any());
    }

    @Test
    public void shouldAcceptDecoratorGivenIntMatrixMessage() {
        DecoratorVisitor mock = mock(ClassicDecorator.class);

        intMatrixMessage.accept(mock);

        verify(mock).decorateIntMatrix(any());
    }
}
