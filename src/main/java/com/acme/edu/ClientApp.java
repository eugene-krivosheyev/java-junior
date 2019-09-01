package com.acme.edu;

import java.io.*;
import java.net.Socket;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class ClientApp {

    public static class LoggerApp {
        PrintWriter out;

        LoggerApp(PrintWriter out){
            this.out = out;
        }

        public void log(int message) {
            out.println("int," + message);
            out.flush();

        }

        public void log(String message) {
            out.println("string," + message);
            out.flush();
        }

        public void flush() {
            out.println("flush");
            out.flush();
        }
    }

    public static void main(String[] args) {
        try (
                final Socket socket = new Socket("localhost", 666);
                final PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(socket.getOutputStream())));
                final BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(socket.getInputStream())));
        ) {

            // todo close without exception
            //запиши то, запиши се
            //формат: тип;"значение"
            LoggerApp loggerApp = new LoggerApp(out);

            for (int i =0; i<10; i++) {
                loggerApp.log(i);
                loggerApp.flush();
                Timer t = new Timer();

                loggerApp.log("qwerty" + i);
                loggerApp.flush();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

          //  System.out.println(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
