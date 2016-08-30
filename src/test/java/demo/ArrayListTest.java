package demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.fest.assertions.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
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

        Saver s = mock(Saver.class);

        assertTrue(result.contains("test data"));
        System.out.println(result);

        //Junit + hamcrest
        //assertThat(result, is(contains("test data")));

        assertThat(result)
            .contains("test data")
            .doesNotContain("!!!!!");

        //endregion
    }
}
