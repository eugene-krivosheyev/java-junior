package paralldemo;

public class ParallelDemo {
    public static void main(String[] args) {
        MyThread controller = new MyThread();

        while (true) {
            System.out.println("main");
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("thread");
        }
    }
}