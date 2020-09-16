package demo.parallelism;

public class VisibilityIssueDemo {
    public static void main(String[] args) throws InterruptedException {
        final Worker thread = new Worker();
        thread.start();

        Thread.sleep(3_000);
        thread.setStopRequested();
        System.out.println("main exited...");
    }
}

class Worker extends Thread {
    private boolean stopRequested;

    @Override
    public void run() {
//        if (!stopRequested) while (true) {}
        while (!stopRequested) {
            synchronized(this) {

            }
        }
    }

    public synchronized void setStopRequested() {
        this.stopRequested = true;
    }
}