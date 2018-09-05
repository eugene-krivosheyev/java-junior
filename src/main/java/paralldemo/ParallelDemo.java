package paralldemo;

public class ParallelDemo {
    public static void main(String[] args) {
        Thread controller = new Thread(new Worker());

        while (true) {
            System.out.println("main");
        }
    }
}

class Worker implements Runnable {
    @Override
    public void run() {

    }
}

