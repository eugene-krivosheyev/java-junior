package com.acme.edu.iteration04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayListTest {
    private List<String> list;

    @Before
    public void setUpSystemOut() throws IOException {
        list = new ArrayList<>();
    }

    @After
    public void tearDown() {
        list.clear();
    }
    //endregion

    @Test
    public void shouldContainString() throws IOException {
        String first = "first";
        String second = "second";
        String third = "third";
        //region when
        list.add(first);
        list.add(second);
        list.add(third);
        //endregion

        //region then
        assertTrue(list.contains(first));
        assertTrue(list.contains(second));
        assertTrue(list.contains(third));
        //endregion
    }
}
