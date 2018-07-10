package com.db.edu.simplelogger.filter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ContentSeverityFilterTest {

    private final Filter<String> filter = new ContentSeverityFilter(ContentSeverityFilter.Severity.INFO);
    @Parameterized.Parameter
    public String message;

    @Parameterized.Parameter(1)
    public boolean isFiltered;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, false},
                {"doesn't match the pattern", false},
                {"[debug] severity in lowercase", false},
                {"[FATAL] invalid severity", false},
                {"[DEBUG] severity lower than required", false},
                {"[INFO] message", true},
                {"[ERROR] message", true}
        });
    }

    @Test
    public void messageLonger() {
        assertEquals(isFiltered, filter.filter(message));
    }
}
