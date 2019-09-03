package com.acme.edu.concurrency;

/**
 * Java8 : JMM: reordering + visibility
 */
public class JmmDemo {
    public static void main(String[] args) throws InterruptedException {
        final StopableThread thread = new StopableThread();
        thread.start();

        Thread.sleep(1_000);

        thread.setStopped(true);
    }
}

class StopableThread extends Thread {
    private volatile boolean stopped = false;

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    @Override
    public void run() {
        while (!stopped) {

        }
    }
}
