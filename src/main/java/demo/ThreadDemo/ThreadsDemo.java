package demo.ThreadDemo;

public class ThreadsDemo {
    public static void main(String[] args) {
        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("th-1");
                }
            }
        });
        worker.start();

        while (true) {
            System.out.println("main");
        }
    }
}
