import com.acme.edu.IntLoggerState;
import com.acme.edu.LoggerPrinter;
import com.acme.edu.LoggerState;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayListTest {
    @Test
    public void shouldSizeIncrementedWhenElementAdded() {
        //region given
        ArrayList sut = new ArrayList();
        Object dummy = new Object();
        //endregion

        //region when
        sut.add(dummy);
        //endregion

        //region then
        assertEquals(1, sut.size());
        //endregion
    }

    @Test
    public void shouldToStringContainsElementsToString() {
        //region given
        ArrayList sut = new ArrayList();
        Object stub = mock(Object.class);
        when(stub.toString()).thenReturn("test string");
        sut.add(stub);
        //endregion

        //region when + then
        assertEquals("[test string]", sut.toString());
        //endregion
    }

    @Test
    public void shouldPrint() {
        LoggerPrinter mock = mock(LoggerPrinter.class);
        LoggerState sut = new IntLoggerState(mock);

        sut.log(5);
        sut.log(5);

        verify(mock, times(1)).print("primitive: 10");
    }
}
