package com.acme.edu.iteration13;

import com.acme.edu.network.ClientStub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main1 {
    private static ArrayList<ClientStub> array = new ArrayList<>();
    static int a = new Random().nextInt()%1000;

    public static void main(String[] args) throws IOException {

        new Thread(new TaskClient()).start();
    }

    static class TaskClient implements Runnable {
        @Override
        public void run() {
            try {
                ClientStub clientStub;
                clientStub = new ClientStub();
                array.add(clientStub);
                for (int i = 0; i < 100000; i++) {
                    clientStub.log("it's message from me" + a);
                }
                //clientStub.flush();
                clientStub.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
