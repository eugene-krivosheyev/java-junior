package com.acme.edu;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class ArrayListTest {

    @Test
    @Disabled
    void shouldAddOneStringToArrayList() {

        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add("string");

        assertTrue(stringArrayList.contains("string"));
        assertEquals(1, stringArrayList.size());
    }

}
