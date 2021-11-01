package com.acme.edu.integration;

import com.acme.edu.Controller;
import com.acme.edu.Flusher;
import com.acme.edu.StatesDTO;
import com.acme.edu.TypeCodeEnum;
import com.acme.edu.message.*;
import com.acme.edu.saver.SystemOutSaver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {
    private final SystemOutSaver saverStub = mock(SystemOutSaver.class);
    private final StatesDTO statesDTO = mock(StatesDTO.class);
    private final Controller controller = new Controller(statesDTO/*new StatesDTO(new Flusher(saverStub))*/, new Flusher(saverStub));


    @BeforeEach
    public void setUp() {
        when(statesDTO.getPrevTypeCodeEnum()).thenReturn(TypeCodeEnum.NONE);
    }

    @Test
    public void shouldFlushWhenLogTwoStringMessage() {
        StringMessage firstStringMessage = mock(StringMessage.class);
        StringMessage secondStringMessage = mock(StringMessage.class);

        when(firstStringMessage.getMessage()).thenReturn("Hello world first");
        when(secondStringMessage.getMessage()).thenReturn("Hello world again");
        when(firstStringMessage.getCode()).thenReturn(TypeCodeEnum.STRING);
        when(secondStringMessage.getCode()).thenReturn(TypeCodeEnum.STRING);

        controller.log(firstStringMessage);
        controller.log(secondStringMessage);

        verify(statesDTO).setPrevString("Hello world first");
        verify(statesDTO).setPrevString("Hello world again");
        verify(statesDTO, times(2)).setPrevTypeCodeEnum(TypeCodeEnum.STRING);
    }

    @Test
    public void shouldSetByteSumWhenLogByte() {
        ByteMessage byteMessage = mock(ByteMessage.class);

        when(byteMessage.getMessage()).thenReturn((byte) 1);
        when(byteMessage.getCode()).thenReturn(TypeCodeEnum.BYTE);

        controller.log(byteMessage);

        verify(statesDTO).setByteSum(byteMessage);
        verify(statesDTO).setPrevTypeCodeEnum(TypeCodeEnum.BYTE);
    }

    @Test
    public void shouldSetPreBooleanWhenLogBoolean() {
        BooleanMessage booleanMessage = mock(BooleanMessage.class);

        when(booleanMessage.getMessage()).thenReturn(true);
        when(booleanMessage.getCode()).thenReturn(TypeCodeEnum.BOOLEAN);

        controller.log(booleanMessage);

        verify(statesDTO).setPrevBoolean(booleanMessage);
        verify(statesDTO).setPrevTypeCodeEnum(TypeCodeEnum.BOOLEAN);
    }

    @Test
    public void shouldSetPrevCharWhenLogChar() {
        CharMessage charMessage = mock(CharMessage.class);

        when(charMessage.getMessage()).thenReturn('A');
        when(charMessage.getCode()).thenReturn(TypeCodeEnum.CHAR);

        controller.log(charMessage);

        verify(statesDTO).setPrevChar(charMessage);
        verify(statesDTO).setPrevTypeCodeEnum(TypeCodeEnum.CHAR);
    }

    @Test
    public void shouldSetIntegerSumWhenLogInteger() {
        IntMessage intMessage = mock(IntMessage.class);

        when(intMessage.getMessage()).thenReturn(11);
        when(intMessage.getCode()).thenReturn(TypeCodeEnum.INTEGER);

        controller.log(intMessage);

        verify(statesDTO).setIntegerSum(intMessage);
        verify(statesDTO).setPrevTypeCodeEnum(TypeCodeEnum.INTEGER);
    }

    @Test
    public void shouldArrayIncrementerWhenLogArray() {
        ArrayMessage arrayMessage = mock(ArrayMessage.class);

        when(arrayMessage.getMessage()).thenReturn(new int[]{1, 2, 3});
        when(arrayMessage.getCode()).thenReturn(TypeCodeEnum.ARRAY_INT);

        controller.log(arrayMessage);

        verify(statesDTO).arrayIncrementer(arrayMessage);
        verify(statesDTO).setPrevTypeCodeEnum(TypeCodeEnum.ARRAY_INT);
    }

    @Test
    public void shouldMatrixIncrementerWhenLogMatrix() {
        MatrixMessage matrixMessage = mock(MatrixMessage.class);

        when(matrixMessage.getMessage()).thenReturn(new int[][]{{1}, {2}, {3}});
        when(matrixMessage.getCode()).thenReturn(TypeCodeEnum.MATRIX_INT);

        controller.log(matrixMessage);

        verify(statesDTO).matrixIncrementer(matrixMessage);
        verify(statesDTO).setPrevTypeCodeEnum(TypeCodeEnum.MATRIX_INT);
    }

    @Test
    public void shouldFlushObjectWhenLogObject() {
        ReferenceMessage referenceMessage = mock(ReferenceMessage.class);

        Object object = new Object();
        when(referenceMessage.getMessage()).thenReturn(new Object());
        when(referenceMessage.getCode()).thenReturn(TypeCodeEnum.OBJECT);

        controller.log(referenceMessage);

        verify(saverStub).save("reference: " + referenceMessage);
        verify(statesDTO).setPrevTypeCodeEnum(TypeCodeEnum.OBJECT);
    }
}
