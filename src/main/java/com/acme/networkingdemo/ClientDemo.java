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

            for (int counter = 0; ; counter++) {
                out.write("command1 arg1");
                out.newLine();
                out.flush();

                if (counter % 1000 == 0) System.out.println(counter);
            }

//            String readLine = in.readLine();
//            System.out.println(">>>> " + readLine);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
