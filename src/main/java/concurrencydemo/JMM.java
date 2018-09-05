package concurrencydemo;

/**
 * Optimizations
 * Visibility
 * Reordering
 */
public class JMM {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread.sleep(1_000);

        myThread.setStopped(true);
    }
}

class MyThread extends Thread {
    private boolean isStopped;

    public synchronized void setStopped(boolean stopped) {
        isStopped = stopped;
    }

    @Override
    public void run() {
        while (!isStopped) {
            synchronized (this) {

            }
        }
    }
}
