package demo.staticdemo;

public class Superman {
    private static final Superman theOne = new Superman();

    public static Superman getTheOne() {
        return theOne;
    }

    //=======================

    private int id;
    private String name;

    private Superman() { }
}

class App {
    public static void main(String[] args) {
        System.out.println(Superman.getTheOne());
        Superman.getTheOne();
        Superman.getTheOne();
        Superman.getTheOne();
        Superman.getTheOne();
        Superman.getTheOne();
    }
}