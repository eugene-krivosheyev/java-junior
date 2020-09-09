package demo.test;

import org.assertj.core.error.AssertionErrorMessagesAggregrator;
import org.hamcrest.CoreMatchers;
import org.jetbrains.annotations.NotNull;
import org.junit.*;
import refactoring.save.Saver;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ArrayListTests {
    private static int CONNECTIONS_COUNT;
    private ArrayList<Object> sut;

    public ArrayListTests() {
        System.out.println("object created!!!");
    }

    @BeforeClass //@AfterClass
    public static void gobalSetUp() {
        CONNECTIONS_COUNT = 5;
        //initDbConnectionsPool(CONNECTIONS_COUNT);
    }

    @Before // @After | @BeforeClass @AfterClass
    public void setUp() {
        sut = new ArrayList<>();
        assumeTrue(sut.size() == 0);
    }

    @Test //BDD practice
    public void shouldContainsElementAndSizeIncrementedWhenElementAdd() {
        //region Fixture, Arrange, Given
        final Object dummy = new Object();
        //endregion

        //region Act | When
        sut.add(dummy);
        //endregion

        //region Assert | Then
        assertTrue(sut.contains(dummy));
        assertEquals("", 1, sut.size());

        //assertThat(sut, allOf(hasItem(dummy))); //hasSize(1)));
        assertThat(sut)
                .hasSize(1)
                .containsExactly(dummy)
                .isNotEmpty();
        //endregion
    }

    @Test
    public void shouldUseElementsStringRepresentationWhenToString() {
        //region given
        //Saver saverStub = mock(Saver.class);
        Object stub = mock(Object.class);
        when(stub.toString())
                .thenReturn("element string representation");
//                .thenReturn()
//                .thenThrow();
//        when(stub.toString(1)).thenReturn("element string representation");
//        when(stub.toString(any())).thenReturn("element string representation");
        sut.add(stub);
        //endregion

        //region when
        final String sutToString = sut.toString();
        //endregion

        //region then
        assertThat(sutToString).contains("element string representation");
        //endregion
    }

    @Test @Ignore
    public void shouldCallElementsToStringWhenToString() {
        Object mock = mock(Object.class);
        sut.add(mock);

        sut.toString();

        verify(mock).toString();
//        verify(mock, times(1)).toString(any());
    }
}
