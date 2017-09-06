package com.acme.edu.jmmdemo;

public class JmmDemo {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        new Thread(worker).start();

        Thread.sleep(5_000);

        worker.setStopped();
    }
}

class Worker implements Runnable {
    private boolean isStopped = false;
    private volatile long l = 5;

    @Override
    public void run() {
            while (!isStopped) {
                synchronized (this) {}
            }
    }

    public synchronized void setStopped() {
        this.isStopped = true;
    }
}