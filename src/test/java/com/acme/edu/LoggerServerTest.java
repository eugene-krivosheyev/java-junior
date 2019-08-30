package com.acme.edu;

import org.junit.Test;

/**
 * Created by kate-c on 30/08/2019.
 */
public class LoggerServerTest {

    @Test
    public void someTest() {
        String request = "IntCommand 2";
        int spaceIndex = request.indexOf(" ");
        String type = request.substring(0, spaceIndex);
        String message = request.substring(spaceIndex + 1, request.length());
        System.out.println(type);
        System.out.println(message);
    }
}
