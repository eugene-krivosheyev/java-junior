package com.acme.edu.remote;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.loggerexceptions.LoggerErrors;
import com.acme.edu.message.Message;
import com.acme.edu.message.MessageWrapper;
import com.acme.edu.saver.ConsoleLoggerSaver;
import com.acme.edu.saver.Saver;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class Session implements Runnable{

    private Socket client;
    PrintWriter out;
    BufferedReader in;

    Session(Socket client) throws IOException {
        this.client = client;
        out = new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                client.getOutputStream())));
        in = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                client.getInputStream())));
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                receive(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LoggerDecoratorException e) {
                e.printStackTrace();
            }

        }
    }

    public  void send(PrintWriter out, int status) {
        out.println(status);
        out.flush();
    }

    public  void receive(BufferedReader in, PrintWriter out) throws IOException, LoggerDecoratorException {
        try {
            String rawMessage = in.readLine();
            Gson gson = MessageWrapper.gson;
            MessageWrapper jsonRawMessage = gson.fromJson(rawMessage, MessageWrapper.class);
            Message unwrapped = jsonRawMessage.unwrap();
            Saver saver = new ConsoleLoggerSaver();
            saver.save(unwrapped.getDecoratedMessage());
        } catch (Exception e) {
            send(out, -1);
        }
        send(out, LoggerErrors.OK.ordinal());
    }

    public void clean() throws IOException {
        in.close();
        out.close();

    }
}