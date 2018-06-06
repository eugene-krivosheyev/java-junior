package demo;

import java.io.PrintStream;

import static demo.President.getTheOne;

public class Main {
    public static void main(String[] args) {
        getTheOne().order("command");
    }
}

//Singleton: DP [GoF] (Head First): роли (ответственности) <-> классы
class President {
    /**
     * IL = Creational Logic
     */
    static {
        System.out.println("HW!!!");
    }


    //Creational Logic: infr
    private static President theOne;

    //region static block
    static {
        theOne = new President();
    }
    //endregion

    public static President getTheOne() {
        return theOne;
    }

    //=============

    /**
     * BL
     */
    private President() {}
    private String name;
    public void order(String command) { //BL

    }
}






class Emplyee {
    int id; //insta

    void instanceMethod() {
        Emplyee.staticMethod(); //or static import
    }


    //=======

    public static void staticMethod() {
    }
}