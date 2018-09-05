package paralldemo;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class ParallelDemo {
    public static void main(String[] args) throws InterruptedException {
       final Thread controlled = new Thread(() -> {
           while (!interrupted()) {
               try {
    //               this != currentThread()
                    System.out.println(currentThread().getName());
                   sleep(100);
               } catch (InterruptedException e) {

               }
           }
       });
       controlled.setDaemon(true);
       controlled.start();
       controlled.stop(); controlled.suspend(); controlled.resume();
       controlled.getName();
       controlled.setPriority(Thread.MAX_PRIORITY); controlled.getPriority();

        controlled.join(10_000);

        controlled.interrupt();
        while (true) {
            sleep(100);
            System.out.println(Thread.currentThread().getName());
        }

    }
}

