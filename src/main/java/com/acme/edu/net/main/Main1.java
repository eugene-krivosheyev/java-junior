package com.acme.edu.net.main;

import com.acme.edu.commands.types.StringCommand;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.net.Client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        new CommandImplListener(8102);
        Thread.sleep(1000);
    }

}
class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit( () -> {
                for (int i = 0; i < 100; i++) {
                    Client client = new Client("localhost", 8102);
                    client.sendCommand(new IntCommand(100));
                    client.sendCommand(new StringCommand("aaa"));
                    client.sendCommand(new StringCommand("aaa"));
                    client.sendCommand(new ByteCommand((byte) 1));
                    client.sendCommand(new StringCommand("hello"));
                    client.sendCommand(new StringCommand("abbba"));
                    client.sendCommand(new StringCommand("abbba"));
                    client.sendCommand(new StringCommand("abbba"));
                    client.sendCommand(new StringCommand("tra"));
                    client.sendCommand(new ByteCommand((byte) 7));
                    client.sendCommand(new ByteCommand((byte) 6));
                    client.sendCommand(new ByteCommand((byte) 10));
                    client.sendCommand(new IntCommand(230));
                    client.sendCommand(new IntCommand(25560));
                    client.sendCommand(new IntCommand(130));
                    client.sendCommand(new ByteCommand((byte)1));
                }
        });
        executorService.shutdown();
        executorService.awaitTermination(1000, TimeUnit.SECONDS);
    }
}
