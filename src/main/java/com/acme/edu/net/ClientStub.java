package com.acme.edu.net;

import java.io.*;
import java.net.Socket;

public class ClientStub {
    public void flush(Writer writer) {
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(int message) {
        try (
            Socket socket = new Socket("127.0.0.1", 6666);
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    socket.getOutputStream())));
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new BufferedInputStream(
                                    socket.getInputStream())))
        ) {
            out.println("log int " + String.valueOf(message));
            flush(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(char message) {

    }

    public void log(String message) {

    }

    public void log(Object message) {

    }

    public void log(int[] message) {

    }

    public void log(int[][] message) {

    }

    public void log(int[][][] message) {

    }
}
