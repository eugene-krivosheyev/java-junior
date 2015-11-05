package com.acme.edu.unit;

import com.acme.edu.*;
import com.acme.edu.states.IntState;
import com.acme.edu.states.StringState;
import com.acme.edu.states.UnBufferState;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

/**
 * Created by Павел on 04.11.2015.
 */
public class LoggerTest {
    private Factory stub;
    private Logger sut;
    private IntState intState;
    private StringState stringState;
    private UnBufferState unBufferState;

    @Before
    public void setUp() throws IOException {
        intState = mock(IntState.class);
        unBufferState = mock(UnBufferState.class);
        stringState = mock(StringState.class);
        stub = mock(Factory.class);
        sut = new Logger(stub);
    }


    @Test
    public void shouldLogIntegersWhenSetIntState() {

        //region given
        when(stub.getIntState()).thenReturn(intState);
        //endregion

        //region when
        sut.log(1);
        sut.log(1);
        //endregion

        //region then
        verify(stub.getIntState(), times(2)).log("1");
        //endregion

    }
    @Test
    public void shouldLogRepeatingStringsWhenSetStringState() {

        //region given
        when(stub.getStringState()).thenReturn(stringState);
        //endregion

        //region when
        sut.log("str 1");
        sut.log("str 1");
        sut.log("str 1");
        sut.flush();
        //endregion

        //region then
        verify(stub.getStringState(), times(3)).log("str 1");
        verify(stub.getStringState(), times(1)).flush();
        //endregion
    }

    @Test
    public void shouldLogArrayAndMatrixWhenSetUnBufferState() {

        //region given
        int[][] dummy = new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}};
        int[] dummyArray = new int[]{-1, 0, 1};
        when(stub.getUnBufferState()).thenReturn(unBufferState);
        //endregion

        //region when
        sut.log(dummyArray);
        sut.log(dummy);
        //endregion

        //region then
        verify(stub.getUnBufferState(), times(1)).log(dummyArray);
        verify(stub.getUnBufferState(), times(1)).log(dummy);
        //endregion
    }
    @Test
    public void shouldLogMultiMatrixWhenSetUnBufferState() {
        //region given
        int[][][][] dummy =  new int[][][][]{{{{0}}}};
        when(stub.getUnBufferState()).thenReturn(unBufferState);
        //endregion

        //region when
        sut.log(dummy);
        //endregion

        //region then
        verify(stub.getUnBufferState(), times(1)).log(dummy);
        //endregion
    }

    @Test
    public void shouldLogCharBooleanObjectWhenSetUnBufferState() {

        //region given
        Object dummy = new Object();
        when(stub.getUnBufferState()).thenReturn(unBufferState);
        //endregion

        //region when
        sut.log('t');
        sut.log(true);
        sut.log(dummy);
        //endregion

        //region then
        verify(stub.getUnBufferState(), times(1)).log("char: " + String.valueOf("t"));
        verify(stub.getUnBufferState(), times(1)).log("primitive: " + String.valueOf(true));
        verify(stub.getUnBufferState(), times(1)).log("reference: " + String.valueOf(dummy));
        //endregion
    }
}
