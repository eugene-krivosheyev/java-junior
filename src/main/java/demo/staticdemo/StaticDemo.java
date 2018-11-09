package demo.staticdemo;

public class StaticDemo {
    private static int staticState = 0;
    private static StaticDemo staticState2;

    private static void sm() {
        System.out.println(staticState);
    }

    public static void main(String[] args) {
        StaticDemo.staticState = 1;
        StaticDemo.sm();

        staticState2 = new StaticDemo();
        staticState2.staticState = 0;
        staticState2.sm();
    }

    static {

    }

    //==============================

    private int instState = 0;

    public StaticDemo(int instState) {
        this.instState = instState;
    }

    void im() {

    }
}

class Human {
    static void killEmAll() {
        killMyself();
    }

    void killMyself() {
        Human.killEmAll();
    }

    public static void main(String[] args) {
        Human vasya = new Human();
        vasya.killEmAll();
        Human.killEmAll();
    }
}
