package com.acme.edu.client;

import java.io.*;
import java.net.Socket;

/**
 * Created by Java_1 on 04.09.2018.
 */
public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("127.0.0.1", 6666);
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(
                                        socket.getOutputStream())));
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(
                                        socket.getInputStream())));
        ) {
 //           out.writeObject(new IntMessage(5));
            out.println("log int 5");
            out.println("log string azaaza gj tju");
            out.println("log string azaaza gj tju");
            out.println("log flush please");
            out.flush();
            String line = null;
            while ((line = in.readLine())!= null) {
                System.out.println("клиент получил: " + line);
          }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class Client2 {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("127.0.0.1", 6666);
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(
                                        socket.getOutputStream())));
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(
                                        socket.getInputStream())));
        ) {
            //           out.writeObject(new IntMessage(5));
            out.println("log int 5");
            out.println("log string azaaza gj tju");
            out.println("log string azaaza gj tju");
            out.println("log flush please");
            out.flush();
            String line = null;
            while ((line = in.readLine())!= null) {
                System.out.println("клиент получил: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}