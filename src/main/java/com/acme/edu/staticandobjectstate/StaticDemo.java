package com.acme.edu.staticandobjectstate;

public class StaticDemo {
    public static void main(String[] args) {
        Integer integer = new Integer(1);
        System.out.println(Integer.MAX_VALUE);

        StaticDemo staticDemo = new StaticDemo();

        SuperMan klark = SuperMan.getInstance();//Singleton
        klark.getName();
        klark.saveTheWorld();
    }
}

class SuperMan {
    public static int count;
    public static final String HOMELAND = "Cripton";

    private static final SuperMan THE_ONE =
            new SuperMan("SM", 10_000);

    /**
     * @return Singleton
     */
    public static SuperMan getInstance() {
        return THE_ONE;
    }

    //================================

    private String name;
    private int speed;

    private SuperMan(String name, int speed) {
        this.name = name;
        this.speed = speed;
        count++;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public void saveTheWorld() {

    }
}
