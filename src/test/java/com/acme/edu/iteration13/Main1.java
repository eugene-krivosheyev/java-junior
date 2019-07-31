package com.acme.edu.iteration13;

import com.acme.edu.network.ClientStub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main1 {
    private static ArrayList<ClientStub> array = new ArrayList<>();
    static Random random = new Random();

    public static void main(String[] args) throws IOException {
        for(int i=0;i<10;i++) {
            new Thread(new TaskClient()).start();
        }
    }

    static class TaskClient implements Runnable {
        @Override
        public void run() {
            try(ClientStub clientStub = new ClientStub()){
                array.add(clientStub);
                int a = random.nextInt()%1000;
                for (int i = 0; i < 1000; i++) {
                    clientStub.log("it's message from me" + a);
                }
                //clientStub.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
