package com.acme.edu.network;

import java.io.*;
import java.net.Socket;

public class ClientStub implements AutoCloseable{
    private Socket server;
    private BufferedReader in;
    private BufferedWriter out;

    public ClientStub() throws IOException {
        server = new Socket("localhost", 8080);

        in = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                server.getInputStream())));
        out = new BufferedWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                server.getOutputStream())));

    }

    private String sendAndGetAnswer(String message) throws IOException {
        out.write(message);
        out.newLine();
        out.flush();
        String answer = in.readLine();
        System.out.println(answer);
        return answer;
    }

    public void flush() throws IOException {
        sendAndGetAnswer("flush");
    }

    public void close() throws IOException {
        sendAndGetAnswer("close");
        in.close();
        out.close();
    }

    public void exit() throws IOException {
        sendAndGetAnswer("exit");
        in.close();
        out.close();
    }

    public void log(int message) throws Exception {
        sendAndGetAnswer("int,"+message);
    }

    //TODO: mas sending
/*
    public void log(int... message) throws Exception {
        loggerController.log(new IntMasCommand(message));
    }

    public static void log(int[][] message) throws Exception {
        loggerController.log(new IntMas2Command(message));
    }

    public static void log(int[][][][] message)  throws Exception {
        loggerController.log(new IntMas4Command(message));
    }
*/
    public void log(byte message) throws Exception {
        sendAndGetAnswer("byte," + message);
    }

    public void log(char message) throws Exception {
        sendAndGetAnswer("char," + message);
    }

    public void log(String message) throws Exception {
        sendAndGetAnswer("string," + message);
    }

    /*
        public static void log(String... message)  throws Exception {
            for(String s:message)
                loggerController.log(new StringCommand(s));
        }
    */
    public void log(Boolean message) throws Exception {
        sendAndGetAnswer("boolean," + String.valueOf(message));
    }
/*
    public static void log(Object message)  throws Exception {
        loggerController.log(new ObjectCommand(message));
    }
    */
}
