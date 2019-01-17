package demo.ThreadDemo;

public class ThreadsDemo {
    public static void main(String[] args) {
        Thread worker = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Th-1");
                }
            }
        };
        worker.start();

        while (true) {
            System.out.println("main");
        }
    }
}
