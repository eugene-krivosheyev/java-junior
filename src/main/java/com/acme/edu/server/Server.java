package com.acme.edu.server;

import com.acme.edu.Logger;
import com.acme.edu.exceptions.LogOperationException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    private static final int PORT = 8080;
    private static ServerSocket connectionListener;
    private static Socket socket;
    private static PrintWriter out;
    private static DataInputStream in;


    Server() throws IOException {
        System.out.println("Server is running");
        connectionListener = new ServerSocket(PORT);
        socket = connectionListener.accept();
        out = new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                socket.getOutputStream())));
        in = new DataInputStream(
                new BufferedInputStream(
                        socket.getInputStream()));
    }

    public static void main(String[] args) {
        try {
            Server s = new Server();
            s.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void run(){
        while (true) {
            try {
                final String readLine = in.readUTF();
                System.out.println("debug: " + readLine);
                processTypesAndLogCommands(readLine);
                out.println("OK");
                out.flush();
            } catch (LogOperationException | IOException e) {
                e.printStackTrace();
                disconnect();
                break;
            }
        }
    }

    private static void disconnect() {
        if (connectionListener != null && !connectionListener.isClosed())
            close();
    }

    private static void close() {
        try {
            in.close();
            out.close();
            socket.close();
            connectionListener.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void processTypesAndLogCommands(String readLine) throws LogOperationException {
        if (readLine.equals("close")) {
            Logger.close();
            return;
        }
        String data = readLine.substring(0, readLine.indexOf("_"));
        String type = readLine.substring(readLine.indexOf("_") + 1);
        switch (type) {
            case "int":
                Logger.log(Integer.parseInt(data));
                break;
            case "byte":
                Logger.log(Byte.parseByte(data));
                break;
            case "string":
                Logger.log(data);
                break;
            case "stringVarArgs":
                Logger.log(data
                        .replace("[", "")
                        .replace("]", "")
                        .split(","));
                break;
            case "integerVarArgs":
                Logger.log(Arrays.stream(data
                        .replace("[", "")
                        .replace("]", "")
                        .split(","))
                        .map(Integer::parseInt));
                break;
            case "integerArray4D": {
                int[][][][] formedData = new int[data.split("}, ?").length][][][];
                //todo
                Logger.log(formedData);
                break;
            }
            case "integerArray2D": {
                int[][] formedData = new int[data.split("}, ?").length][];
                int index = 0;
                for (String str : data.split("}, ?")) {
                    String temp = str.replace("{", "").replace("}", "");
                    String[] strArray = temp.split(",");
                    int[] intArray = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();
                    formedData[index++] = intArray;
                }
                Logger.log(formedData);
                break;
            }
            case "integerArray1D":
                Logger.log(Arrays.stream(data
                        .replace("[", "")
                        .replace("]", "")
                        .split(","))
                        .map(Integer::parseInt));
                break;
            case "boolean":
                Logger.log(Boolean.parseBoolean(data));
                break;
            case "object":
                Logger.log(data); //todo parse Object
                break;
            case "char":
                Logger.log(data.charAt(0));
                break;
        }
    }
}
