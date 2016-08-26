package demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@SuppressWarnings("unchecked")
public class ArrayListTest {
    private ArrayList testList;

    @Before
    public void setUp() {
        testList = new ArrayList();
    }

    @Test
    public void shouldSizeIncrementedWhenElementAdded() {
        //region Given
        Object dummy = new Object();
        //endregion

        //region When
        testList.add(dummy);
        //endregion

        //region Then
        assertEquals(
            "ldfgjhdkfgjhdkfjhgdkfjgh",
            1, testList.size()
        );
        //endregion
    }

    @Test
    public void shouldElementsAccessedWhenToString() {
        //region Given
        Object stub = mock(Object.class);
        when(stub.toString()).thenReturn("test data");
        testList.add(stub);
        //endregion

        //region When
        String result = testList.toString();
        //endregion

        //region Then
        verify(stub).toString();
        assertTrue(result.contains("test data"));
        System.out.println(result);
        //endregion
    }
}
