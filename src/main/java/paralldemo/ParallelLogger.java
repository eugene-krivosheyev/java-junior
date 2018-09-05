package paralldemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.interrupted;
import static java.util.concurrent.Executors.newFixedThreadPool;

public class ParallelLogger {
    public static void main(String[] args) {

    }
}

class Logger {
    public static void main(String[] args) throws IOException {
        ServerSocket portListener = new ServerSocket(6666);
        ExecutorService pool = newFixedThreadPool(10_000);

        new Thread(() -> {
                try {
                    while (!interrupted()) {
                        Socket clientSession = portListener.accept();
                        pool.execute(new Session(clientSession));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }).start();
    }
}

class Session implements Runnable {
    private Socket client;

    Session(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            //client.readLine()
            //logic
            //client.writeLine(response)
        }
    }
}