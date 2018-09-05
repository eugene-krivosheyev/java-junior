package paralldemo;

public class ParallelDemo {
    public static void main(String[] args) {
        Thread controller = new Thread(() -> {
            while (true) {
                System.out.println("thread");
            }
        });

        while (true) {
            System.out.println("main");
        }
    }
}

