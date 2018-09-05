package com.acme.edu.remote;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;
import com.acme.edu.message.*;
import com.acme.edu.message.decorator.DefaultDecorator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private List<Message> messagePool;

    public Client() {
        messagePool = new ArrayList<Message>();
    }

    public void addMessageToPool(Message message) {
        messagePool.add(message);
    }

    public void sendMessagePool() throws LoggerDecoratorException {
        try (
                Socket socket = new Socket(RemoteConfiguration.HOST, RemoteConfiguration.PORT_NUMBER);
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(
                                new BufferedOutputStream(
                                        socket.getOutputStream())));
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                new BufferedInputStream(
                                        socket.getInputStream())));
        ) {
            for (Message message : messagePool) {
                System.out.print("Client sent: " + message.getDecoratedMessage());
                send(out, new MessageWrapper(message));
                out.flush();
                receive(in);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(PrintWriter out, MessageWrapper message) {
        Gson gson = MessageWrapper.gson;

        String jsonMessage = message.wrap();
        out.println(jsonMessage);
    }

    public void receive(BufferedReader in) throws IOException {
        String status = in.readLine();
        System.out.println("Client received: " + status);
    }

    public static void main(String[] args) throws LoggerDecoratorException {
        Client client = new Client();
        client.addMessageToPool(new StringMessage("test 1", new DefaultDecorator("string")));
        client.addMessageToPool(new StringMessage("test 2", new DefaultDecorator("string")));
        client.addMessageToPool(new StringMessage("test 3", new DefaultDecorator("string")));
        client.addMessageToPool(new DefMessage(new DefaultDecorator("failure")));
        client.sendMessagePool();
    }


}
