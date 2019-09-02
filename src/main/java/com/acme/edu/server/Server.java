package com.acme.edu.server;

import com.acme.edu.Logger;
import com.acme.edu.exceptions.LogOperationException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("Server is running");
        try (final ServerSocket connectionListener = new ServerSocket(PORT)) {
            ExecutorService threadPool = Executors.newFixedThreadPool(20);
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    final Socket socket = connectionListener.accept();
                    threadPool.submit(new ClientHandler(socket));
                }
            } finally {
                threadPool.shutdown();
            }
        } catch (IOException e) {
            e.printStackTrace();
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

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (final BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    socket.getOutputStream())));
                 final BufferedReader in =
                         new BufferedReader(
                                 new InputStreamReader(
                                         socket.getInputStream()))) {
                final String readLine = in.readLine();
                System.out.println("debug: " + readLine);
                processTypesAndLogCommands(readLine);
                out.write("OK");
                out.flush();
            } catch (LogOperationException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
