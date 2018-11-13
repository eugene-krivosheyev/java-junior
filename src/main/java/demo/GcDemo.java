package demo;

public class GcDemo {
    public static void main(String[] args) {
        while (true) {
            new Spider();
        }
    }
}

class Spider {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("");
    }
}
