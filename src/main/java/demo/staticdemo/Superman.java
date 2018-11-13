package demo.staticdemo;

public class Superman {
    private int id;
    private String name;

    Superman() { }

    public void doSaveTheWorld() {
//        try (Kriptont k = new Kriptonit()) { //Closeable | AutoCloseable

//        } //k.close()
    }

    @Override
    protected void finalize() throws Throwable { //-verbose:gc
//        file.close();
//        connection.close();
        System.out.println("AAAAAQAAA!!!!!");
    }
}

class SupermanFactory {
    private static volatile Superman theOne; //EAGER

    public static Superman getTheOne() { //LAZY
        if (theOne != null) return theOne;

        synchronized(theOne) {
            if (theOne != null) return theOne;
            theOne = new Superman();
            return theOne;
        }
    }
}

class App {
    public static void main(String[] args) {
        System.out.println(SupermanFactory.getTheOne());

        Superman s1 = new Superman();
//        SuperPuperRegistry.register(s1); //Possible Memory Leak

        System.gc(); //

        SupermanFactory.getTheOne();
        SupermanFactory.getTheOne();
        SupermanFactory.getTheOne();
        SupermanFactory.getTheOne();
        SupermanFactory.getTheOne();
    }
}