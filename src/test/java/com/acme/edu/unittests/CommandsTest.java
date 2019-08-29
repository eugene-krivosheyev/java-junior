package com.acme.edu.unittests;

import com.acme.edu.Logger;
import com.acme.edu.commands.*;
import com.acme.edu.exceptions.LogOperationException;
import com.acme.edu.exceptions.SaverException;
import com.acme.edu.savers.ConsoleSaver;
import com.acme.edu.savers.Saver;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class CommandsTest {
    @Test
    public void shouldWriteToLogs(){
        try {
            Logger.log(1);
            Logger.log(2);
            Logger.log("2");
            Logger.close();
        } catch (LogOperationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldDecorateCharCommand() {
        CharCommand sut = new CharCommand("a");
        assertEquals("char: a", sut.decorate());
    }

    @Test
    public void shouldDecorateReferenceCommand() {
        ReferenceCommand sut = new ReferenceCommand(String.valueOf(new Object()));
        assertTrue(sut.decorate().contains("@"));
    }

    @Test
    public void shouldDecorateArrayCommand() {
        ArrayCommand sut = new ArrayCommand(new int[]{-1, 0, 1});
        assertEquals("primitives array: {-1, 0, 1}", sut.decorate());
    }

    @Test
    public void shouldDecorateMatrixCommand() {
        MatrixCommand sut = new MatrixCommand(new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        assertEquals("primitives matrix: {\n" +
                "{-1, 0, 1}\n" +
                "{1, 2, 3}\n" +
                "{-1, -2, -3}\n" +
                "}", sut.decorate());
    }

    @Test
    public void shouldDecorateMultiMatrixCommand() {
        MultiMatrixCommand sut = new MultiMatrixCommand(new int[][][][]{{{{0}}}});
        assertEquals("primitives multimatrix: {\n" +
                        "{\n" + "{\n" + "{\n" +
                        "0\n" +
                        "}\n" + "}\n" + "}\n" +
                        "}", sut.decorate());
    }

    @Test
    public void shouldDecorateStringCommand() {
        StringCommand sut = new StringCommand("");
        assertEquals("string: ", sut.decorate());
    }

    @Test
    public void shouldDecoratePrimitiveCommand() {
        PrimitiveCommand sut = new PrimitiveCommand("1");
        assertEquals("primitive: 1", sut.decorate());
    }

    @Test
    public void shouldStringCounterEqualsToOneWhenFirstAccumulatedValuePassed() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        StringCommand sut = new StringCommand("str");
        Method m = sut.getClass().getDeclaredMethod("getCounter");
        m.setAccessible(true);

        assertEquals(1, m.invoke(sut));
    }

    @Test
    public void shouldStringBufferEqualsToStrWhenFirstAccumulatedValuePassed() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor[] declaredConstructors = StringCommand.class.getDeclaredConstructors();
        Constructor constructor = declaredConstructors[1];
        constructor.setAccessible(true);
        StringCommand sut = (StringCommand) constructor.newInstance("str", 1);

        Method m = sut.getClass().getDeclaredMethod("getBuffer");
        m.setAccessible(true);

        assertEquals("str", m.invoke(sut));
    }

    @Test
    public void shouldFlushStringCommandWhenFlushCalledAndCounterIsOne() throws SaverException {
        StringCommand mockString = mock(StringCommand.class);
        Whitebox.setInternalState(mockString, "buffer", "message");
        Whitebox.setInternalState(mockString, "counter", 1);
        Saver mockSaver = mock(ConsoleSaver.class);
        doCallRealMethod().when(mockString).flush(mockSaver);

        mockString.flush(mockSaver);

        verify(mockString).flush(mockSaver);
    }

    @Test
    public void shouldFlushStringCommandWhenFlushCalledAndCounterIsNotOne() throws SaverException {
        StringCommand mockString = mock(StringCommand.class);
        Whitebox.setInternalState(mockString, "buffer", "message");
        Whitebox.setInternalState(mockString, "counter", 2);
        Saver mockSaver = mock(ConsoleSaver.class);
        doCallRealMethod().when(mockString).flush(mockSaver);

        mockString.flush(mockSaver);

        verify(mockString).flush(mockSaver);
    }

    @Test
    public void shouldFlushStringBufferWhenMessagesAreDifferent() throws SaverException {
        StringCommand mockAccumulate = mock(StringCommand.class);
        Whitebox.setInternalState(mockAccumulate, "buffer", "msg");
        ConsoleSaver mockSaver = mock(ConsoleSaver.class);
        doNothing().when(mockAccumulate).flush(mockSaver);

        StringCommand sut = new StringCommand("different msg");
        sut.accumulate(mockAccumulate, mockSaver);

        verify(mockAccumulate).flush(mockSaver);
    }

    @Test
    public void shouldFlushStringBufferWhenMessagesAreSame() throws SaverException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        StringCommand mockAccumulate = mock(StringCommand.class);
        Whitebox.setInternalState(mockAccumulate, "buffer", "msg");
        Whitebox.setInternalState(mockAccumulate, "counter", 1);
        ConsoleSaver mockSaver = mock(ConsoleSaver.class);
        doNothing().when(mockAccumulate).flush(mockSaver);

        StringCommand sut = new StringCommand("msg");
        AccumulateCommand resultAccum = sut.accumulate(mockAccumulate, mockSaver);

        Method m = resultAccum.getClass().getDeclaredMethod("getCounter");
        m.setAccessible(true);

        assertEquals(2, m.invoke(resultAccum));
    }

    @Test
    public void shouldPrimitiveBufferEqualsToOneWhenFirstAccumulatedValuePassed() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor[] declaredConstructors = PrimitiveCommand.class.getDeclaredConstructors();
        Constructor constructor = declaredConstructors[0];
        constructor.setAccessible(true);
        PrimitiveCommand sut = (PrimitiveCommand) constructor.newInstance("1");

        Method m = sut.getClass().getDeclaredMethod("getBuffer");
        m.setAccessible(true);

        assertEquals("1", m.invoke(sut));
    }
}
