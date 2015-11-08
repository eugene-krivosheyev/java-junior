package com.acme.edu.unit.LoggerTest;

import com.acme.edu.logger.Factory;
import com.acme.edu.logger.LogException;
import com.acme.edu.logger.Logger;
import com.acme.edu.states.IntState;
import com.acme.edu.states.StringState;
import com.acme.edu.states.UnBufferState;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Павел on 08.11.2015.
 */
public class LoggerExceptionTest {
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


    @Test (expected = LogException.class)
    public void shouldLogUnBufferStateExceptionWhenInputArrayNullAndEmpty() throws Exception{

        //region given
        when(stub.getUnBufferState()).thenReturn(unBufferState);
        //endregion

        //region when
        sut.log((int[])null);
        sut.log(new int[]{});
        //endregion
    }

    @Test (expected = LogException.class)
    public void shouldLogExceptionWhenInputMatrixNullAndEmpty() throws Exception{

        //region given
        when(stub.getUnBufferState()).thenReturn(unBufferState);
        //endregion

        //region when
        sut.log((int[][])null);
        sut.log(new int[][]{});
        //endregion
    }

    @Test (expected = LogException.class)
    public void shouldLogOutputExceptionWhenInputMultiMatrixNullAndEmpty() throws Exception{

        //region given
        when(stub.getUnBufferState()).thenReturn(unBufferState);
        //endregion

        //region when
        sut.log((int[][][][])null);
        sut.log(new int[][][][]{});
        //endregion
    }

    @Test (expected = LogException.class)
    public void shouldLogOutputExceptionWhenInputObjectNull() throws Exception{

        //region given
        when(stub.getUnBufferState()).thenReturn(unBufferState);
        //endregion

        //region when
        sut.log((Object)null);
        //endregion
    }
    @Test (expected = LogException.class)
    public void shouldLogOutputExceptionWhenInputStringEmptyAndNull() throws Exception{

        //region given
        when(stub.getUnBufferState()).thenReturn(unBufferState);
        //endregion

        //region when
        sut.log("");
        sut.log(String.valueOf(null));
        //endregion
    }
}
