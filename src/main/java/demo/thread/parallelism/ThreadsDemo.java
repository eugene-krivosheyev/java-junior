package demo.thread.parallelism;

public class ThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        final Thread threadObject = new Thread(new Runnable() {
            public void run() {
                while (!Thread.interrupted()) {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1_000);

                    } catch (InterruptedException e) {
                        System.out.println("INTERRUPTED!!!");
                        Thread.currentThread().interrupt();
                    }
                    //Thread-1
                }
            }
        });

        threadObject.start();
//        threadObject.suspend(); | resume()
//        threadObject.stop();

        Thread.sleep(5_000);
        threadObject.interrupt();
    }
}
