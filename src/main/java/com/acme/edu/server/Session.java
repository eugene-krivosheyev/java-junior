package com.acme.edu.server;

import com.acme.edu.Logger;
import com.acme.edu.controller.LogOperationException;

import java.io.*;
import java.net.Socket;

/**
 * Created by Java_1 on 05.09.2018.
 */
public class Session implements Runnable {
    private BufferedReader in;
    private Socket client;
    private PrintWriter out;

    public Session(Socket client) {
        this.client = client;

        try {


            this.out = new PrintWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    client.getOutputStream())));

            this.in = new BufferedReader(
                    new InputStreamReader(
                            new BufferedInputStream(
                                    client.getInputStream())));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            String line = null;
            try {
                while ((line = in.readLine()) != null) {
                    String delims = " ";
                    String[] tokens = line.split(delims);
                    String type = tokens[1];
                    System.setOut((PrintStream)client.getOutputStream());
                    try {
                        switch (type) {
                            case "int":
                                Logger.log(Integer.parseInt(tokens[2]));
                                break;
                            case "string":
                                String array = tokens[2] + " ";
                                for (int i = 3; i < tokens.length; i++) {
                                    array = array + tokens[i] + " ";
                                }
                                Logger.log(array);
                                break;
                            case "byte":
                                Logger.log(Byte.parseByte(type));
                                break;
                            case "boolean":
                                Logger.log(Boolean.parseBoolean(type));
                                break;
                            case "flush":
                                Logger.flush();
                                break;
                        }
                    } catch (LogOperationException e) {
                        e.printStackTrace();
                    }

                    out.println();
                    out.flush();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                Logger.flush();
            } catch (LogOperationException e) {
                e.printStackTrace();
            }
        }

        try {
            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
