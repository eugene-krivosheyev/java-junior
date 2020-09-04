package demo;

public class ProcedureStyleReuseDemo {
    public static void main(String[] args) {
//        printByte();
//        printInt();

        print(Byte.MAX_VALUE, 0);
        print(Integer.MAX_VALUE, 1);
    }

    /*
    private static void printInt() {
        //....
        //...
        m();
        //..
    }

    private static void printByte() {
        ///....
        ///....
        m2();
        //...
    }
    */

    private static void print(int MAX_TRESHOLD, int behavior) {
        ///....
        ///....
        if (behavior == 0) {
            //??????????
        } else if (behavior == 1) {
            //????????
        } else {

        }
        //...
    }
}


