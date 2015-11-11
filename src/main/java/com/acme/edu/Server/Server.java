package com.acme.edu.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Павел on 07.11.2015.
 */
public class Server implements Runnable {
    //region fields
    private String encoding;
    private int port;
    private Socket client;
    private Object monitor = new Object();

    private ExecutorService pool = Executors.newFixedThreadPool(5);
    private final List<Socket> listSocket = new LinkedList<>();
    //endregion

    /**
     * Initialize number port
     *
     * @param port the port number
     * @throws IOException
     */
    public Server(int port, String encoding) throws IOException {
        this.port = port;
        this.encoding = encoding;
    }

    /**
     * start the server
     *
     * @throws ServerException
     * @throws IOException
     */
    public void startServer() throws ServerException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
           // Lock lock = ReentrantReadWriteLock посмотреть в гугле
            while (!Thread.interrupted()) {
                client = serverSocket.accept();
                listSocket.add(client);
                pool.execute(new Proactor(client, encoding, monitor));
                /*Future<String> future = pool.submit(() -> {   //Вопрос с коллекцией сокетов и получением исключений через future!
                    throw new ServerException("...");              //
                });
                    future.get();*/
            }
        } catch (IOException e) {
            serializeException(new ServerException(e));
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    new ServerException(e);
                }
            }
            if (pool != null) {
                pool.shutdown();
            }
        }
    }

    private void serializeException(Exception e) throws ServerException {
        try (ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());) {
            out.writeObject(e.toString());
        } catch (IOException e1) {
            throw new ServerException(e1);
        }
    }

    /**
     * Start the server from the stream
     */
    @Override
    public void run() {
        try {
            startServer();
        } catch (ServerException e) {
            e.printStackTrace();
        }
    }
}
