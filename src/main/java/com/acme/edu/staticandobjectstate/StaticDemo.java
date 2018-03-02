package com.acme.edu.staticandobjectstate;

public class StaticDemo {
    private int objectState;

    public static void main(String[] args) {
        Integer integer = new Integer(1);
        System.out.println(Integer.MAX_VALUE);

        StaticDemo staticDemo = new StaticDemo();

        SuperMan klark = SuperMan.getInstance();//Singleton
        klark.getName();
        klark.saveTheWorld();

    }

    static void printToConsole(DecorType decorType) {
        /*
        switch (decorType) {
            case PR:
                System.out.println("primitive: ");
                break;
            case ST:
                System.out.println("string: ");
                break;
        }
        */
    }
}

/**
 * 1. Mnemo-code for behavior: future switch
 * 2. Comple type: протащим с собой всю нужную инфо
 */
enum DecorType {
//    PR(1,2,3,"primitive"), ST()
}

enum SupermanState {
    HIDING, OPEN
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
    private SupermanState state = SupermanState.HIDING;

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
        if (state == SupermanState.HIDING) return;
        //....
    }
}
