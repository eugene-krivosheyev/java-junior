package com.acme.edu;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayListTest {

    @Test
    void shouldAddOneStringToArrayList() {

        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add("string");

        assertTrue(stringArrayList.contains("string"));
        assertEquals(1, stringArrayList.size());
    }

}
