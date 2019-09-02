package com.acme.edu.unittests;

import com.acme.edu.client.LoggerClient;

public class ThreadsTest {
    public static void main(String[] args) {
        LoggerClient.log(1);
        LoggerClient.close();
    }
}
