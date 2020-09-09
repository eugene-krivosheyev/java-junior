package demo.test;

import org.assertj.core.error.AssertionErrorMessagesAggregrator;
import org.jetbrains.annotations.NotNull;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

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
        //endregion
    }

    @Test
    public void dummyTest() {

    }
}
