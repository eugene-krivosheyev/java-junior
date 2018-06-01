package demo;

import static demo.President.getTheOne;

public class Main {
    public static void main(String[] args) {
        getTheOne().order("command");
    }
}

//Singleton: DP [GoF] (Head First)
class President {
    //Creational Logic: infr
    private static President theOne = new President();

    public static President getTheOne() {
        return theOne;
    }

    //=============

    private President() {}

    public void order(String command) { //BL

    }
}