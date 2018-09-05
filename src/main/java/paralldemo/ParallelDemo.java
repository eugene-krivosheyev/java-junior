package paralldemo;

public class ParallelDemo {
    public static void main(String[] args) {
        Thread controller = new Thread() {
            @Override
            public void run() {
                super.run();
            }
        };

        while (true) {
            System.out.println("main");
        }
    }
}

