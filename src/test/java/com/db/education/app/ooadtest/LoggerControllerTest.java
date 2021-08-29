package com.db.education.app.ooadtest;

import com.db.education.app.controller.LoggerController;
import com.db.education.app.message.*;
import com.db.education.app.saver.Saver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoggerControllerTest {

    private LoggerController controllerSut;
    private Saver saverDummy;

    @BeforeEach
    public void setUp() {
        saverDummy = mock(Saver.class);
        controllerSut = new LoggerController(saverDummy);
    }

    @Test
    public void shouldGetErrorWhenNoMessageProvided() {
        Message noMessage = null;

        assertThrows(
                IllegalArgumentException.class,
                () -> controllerSut.processMessage(noMessage)
        );
    }

    @Test
    public void shouldGetErrorWhenMessageIsEmpty() {
        Message emptyMessage = mock(EmptyMessage.class);
        when(emptyMessage.isEmptyMessage()).thenReturn(true);

        assertThrows(
                IllegalArgumentException.class,
                () -> controllerSut.processMessage(emptyMessage)
        );
    }

    @Test
    public void shouldUpdateWhenFirstMessageProvided() {
        Message byteMessageDummy = mock(ByteMessage.class);

        controllerSut.processMessage(byteMessageDummy);
        controllerSut.flush();

        verify(saverDummy).save(byteMessageDummy);
    }

    @Test
    public void shouldAccumulateAndNotFlushWhenAccumulatableMessagesProvided() {
        Message intMessageDummyFirst = mock(IntegerMessage.class);
        Message intMessageDummySecond = mock(IntegerMessage.class);
        Message intMessageDummyThird = mock(IntegerMessage.class);
        when(intMessageDummyFirst.accumulate(intMessageDummySecond)).thenReturn(intMessageDummyFirst);
        when(intMessageDummyFirst.accumulate(intMessageDummyThird)).thenReturn(intMessageDummyFirst);
        when(intMessageDummyFirst.needsFlush()).thenReturn(false).thenReturn(false).thenReturn(false);

        controllerSut.processMessage(intMessageDummyFirst);
        controllerSut.processMessage(intMessageDummySecond);
        controllerSut.processMessage(intMessageDummyThird);

        verify(saverDummy, never()).save(any());
    }

    @Test
    public void shouldFlushOnceWhenNonAccumulatableMessageNeedsFlushing() {
        Message charMessageDummy = mock(CharacterMessage.class);
        when(charMessageDummy.needsFlush()).thenReturn(true);

        controllerSut.processMessage(charMessageDummy);

        verify(saverDummy, times(1)).save(charMessageDummy);
    }

    @Test
    public void shouldFlushProperMessageWhenAccumulatableMessageNeedsFlushing() {
        Message intMessageDummyFirst = mock(IntegerMessage.class);
        Message intMessageDummySecond = mock(IntegerMessage.class);
        when(intMessageDummyFirst.accumulate(intMessageDummySecond)).thenReturn(intMessageDummyFirst);
        when(intMessageDummyFirst.needsFlush()).thenReturn(false).thenReturn(true);

        controllerSut.processMessage(intMessageDummyFirst);
        controllerSut.processMessage(intMessageDummySecond);

        verify(saverDummy, times(1)).save(intMessageDummyFirst);
        verify(saverDummy, never()).save(intMessageDummySecond);
    }

    @Test
    public void shouldNotFlushWhenInvokedOnInitialState() {
        controllerSut.flush();

        verify(saverDummy, never()).save(any());
    }

    @Test
    public void shouldFlushWhenInvokedOnNonEmptyMessage() {
        Message objectMessageDummy = mock(ObjectMessage.class);
        when(objectMessageDummy.needsFlush()).thenReturn(false);

        controllerSut.processMessage(objectMessageDummy);
        controllerSut.flush();

        verify(saverDummy, times(1)).save(objectMessageDummy);
    }

    @Test
    public void shouldNotFlushWhenInvokedOnEmptyMessage() {
        Message booleanMessageDummy = mock(BooleanMessage.class);
        when(booleanMessageDummy.needsFlush()).thenReturn(false);

        controllerSut.processMessage(booleanMessageDummy);
        controllerSut.flush();
        controllerSut.flush();

        verify(saverDummy, times(1)).save(any());
    }
}
