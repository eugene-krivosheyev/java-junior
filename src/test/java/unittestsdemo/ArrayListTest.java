package unittestsdemo;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ArrayListTest {
    private ArrayList sut;
    //????????

    @Before //@BeforeClass
    public void setUp() {
        sut = new ArrayList();
    }

    @Test
    public void shouldAddElementWhenElementIsNull() {
        //region Given | Fixture
        Object testObject = null;
        //endregion

        //region When
        sut.add(testObject);
        //endregion

        //region Then
        assertEquals(1, sut.size());
        assertNull(sut.get(0));
//        assertThat(sut)
//            .contains(null)
//            .hasSize(1);
        assertTrue(sut.get(0) == null);
        //endregion
    }

    @Test
    public void shouldBasedOnElementsWhenToString() {
        Object stub = mock(Object.class);
        when(stub.toString()).thenReturn("test");
        sut.add(stub);

        assertThat(sut.toString()).contains("[test]");
    }

    @Test @Ignore
    public void shouldBasedOnElementsWhenToString2() {
        Object mock = mock(Object.class);
        sut.add(mock);

        sut.toString();

        verify(mock, times(1)).toString();
    }
}
