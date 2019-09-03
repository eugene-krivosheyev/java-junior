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
    private boolean stopped = false;

    public synchronized void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public boolean isStopped() {
        return stopped;
    }

    @Override
    public void run() {
        //https://docs.oracle.com/javase/specs/jls/se7/html/jls-17.html#jls-17.4.5
        synchronized (this) {
            while (!isStopped()) {

            }
        }
    }
}
