package com.acme.edu.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class MultiClientServer {
    public static void main(String[] args) throws IOException {
        Thread connectionLoop = new Thread(new ServerAcceptor());
        connectionLoop.start();

        //*wait* form admin
        Runtime.getRuntime().addShutdownHook(
                new Thread(connectionLoop::interrupt)
        );
    }
}

class ServerAcceptor implements Runnable {
    private ServerService service = new ConcreteServerService();
    private Set<Thread> clientSessions = new HashSet<>();

    public void run()  {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            serverSocket.setSoTimeout(1_000);
            while (!Thread.interrupted()) {
                Socket clientSocket = serverSocket.accept();
                if (clientSocket != null) {
                    Thread thread = new Thread(
                        new ClientSession(clientSocket, service)
                    );
                    clientSessions.add(thread);
                    thread.start();
                }
            }
            clientSessions.forEach(Thread::interrupt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientSession implements Runnable {
    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;
    private ServerService service;

    public ClientSession(Socket accept, ServerService service) throws IOException {
        this.clientSocket = accept;
        this.service = service;
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                String clientInputLine = reader.readLine();
                writer.println(service.doCommand(clientInputLine));
            }

            reader.close();
            writer.close();
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

interface ServerService {
    String doCommand(String clientInputLine);
}

class ConcreteServerService implements ServerService {
    @Override
    public String doCommand(String clientInputLine) {
        return null;
    }
}