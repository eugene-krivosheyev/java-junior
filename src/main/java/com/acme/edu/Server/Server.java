package com.acme.edu.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Павел on 07.11.2015.
 */
public class Server implements Runnable{
    //region fields
    private String encoding;
    private int port;
    private Socket client;
    private ExecutorService pool = Executors.newFixedThreadPool(5);
    private List<Socket> listSocket = new ArrayList<>();
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
            while (true) {
                client = serverSocket.accept();
                listSocket.add(client);

                pool.execute(new ServerManager(client, encoding));
                /*Future<String> future = pool.submit(() -> {   //Вопрос с коллекцией сокетов и получением исключений через future!
                    throw new ServerException("...");
                });
                    future.get();*/
            }
        }catch (IOException e) {
            serializeException(new ServerException(e));
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    throw new ServerException(e);
                }
            }
            if (pool != null) {
                pool.shutdown();
            }
        }
    }

    private void serializeException(Exception e) throws ServerException {
        try(ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());) {
            out.writeObject(e.toString());
        }catch (IOException e1){
            throw new ServerException(e1);
        }
    }

    @Override
    public void run() {
        try {
            startServer();
        } catch (ServerException e) {
            e.printStackTrace();
        }
    }
}
