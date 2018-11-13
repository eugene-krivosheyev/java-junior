package demo.staticdemo;

public class Superman {
    private int id;
    private String name;

    Superman() { }
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

        SupermanFactory.getTheOne();
        SupermanFactory.getTheOne();
        SupermanFactory.getTheOne();
        SupermanFactory.getTheOne();
        SupermanFactory.getTheOne();
    }
}