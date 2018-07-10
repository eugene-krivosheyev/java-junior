package com.db.edu.simplelogger.filter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MessageLengthFilterTest {

    private final Filter<String> filter = new MessageLengthFilter(15);
    @Parameterized.Parameter
    public String message;

    @Parameterized.Parameter(1)
    public boolean isFiltered;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, false},
                {"very long message", false},
                {"short message", true}
        });
    }

    @Test
    public void messageLonger() {
        assertEquals(isFiltered, filter.filter(message));
    }
}
