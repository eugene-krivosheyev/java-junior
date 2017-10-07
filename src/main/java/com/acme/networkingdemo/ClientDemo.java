package com.acme.networkingdemo;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) {
        try (
                Socket connection = new Socket("localhost", 9999);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(
                                        connection.getInputStream())));

                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(
                                        connection.getOutputStream())));
        ) {

            out.write("command1 arg1");
            out.newLine();
            out.flush();

            System.out.println(">>>> " + in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
