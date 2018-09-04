package com.acme.edu.systemtest;

import com.acme.edu.clientside.LoggerProxy;
import com.acme.edu.serverside.Server;
import org.junit.*;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;
import static org.junit.Assert.assertEquals;

public class SystemTest {
/*
    private static Thread thread;
    @BeforeClass
    public static void setup() throws IOException {
        thread = new Thread(() -> {
            Server.main(null);});
        thread.start();
        LoggerProxy.connect("127.0.0.1", 6666);
    }

    @AfterClass
    public static void shutDown() throws IOException {
        LoggerProxy.disconnect();
       // thread.stop();
    }

    @Test
    public  void shouldLogInt() throws IOException {
        int toLog = 10;
        LoggerProxy.log(toLog);
        LoggerProxy.flush();

        //String readLine = bufferedReader.readLine();
        List<String> collect = lines(get("default.txt")).collect(Collectors.toList());
        String readLine = collect.get(collect.size() - 1);

        assertEquals("primitive: " + toLog, readLine);
    }

    @Test
    public  void shouldLogByte() throws IOException {
        byte toLog = (byte)10;
        LoggerProxy.log(toLog);
        LoggerProxy.flush();

        List<String> collect = lines(get("default.txt")).collect(Collectors.toList());
        String readLine = collect.get(collect.size() - 1);

        assertEquals("primitive: " + toLog, readLine);
    }

    @Test
    public  void shouldLogBoolean() throws IOException {
        boolean toLog = true;
        LoggerProxy.log(toLog);
        LoggerProxy.flush();

        List<String> collect = lines(get("default.txt")).collect(Collectors.toList());
        String readLine = collect.get(collect.size() - 1);
        //  .filter(new )  .reduce("", (e1, e2) -> e2);

        assertEquals("primitive: " + toLog, readLine);
    }

    @Test
    public  void shouldLogChar() throws IOException {
        char toLog = 'A';
        LoggerProxy.log(toLog);
        LoggerProxy.flush();

        List<String> collect = lines(get("default.txt")).collect(Collectors.toList());
        String readLine = collect.get(collect.size() - 1);

        assertEquals("char: " + toLog, readLine);
    }

    @Test
    public  void shouldLogString() throws IOException {
        String toLog = "testttt";
        LoggerProxy.log(toLog);
        LoggerProxy.flush();

        List<String> collect = lines(get("default.txt")).collect(Collectors.toList());
        String readLine = collect.get(collect.size() - 1);

        assertEquals("string: " + toLog, readLine);
    }*/
}
