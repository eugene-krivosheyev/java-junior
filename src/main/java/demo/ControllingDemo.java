package demo;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class ControllingDemo {
    public static void main(String[] args) {
        //region branch
        if (1 == 1) {
        } else if ( 2 == 3) {

        } else {

        }

        System.out.println("begin...");
        String i1 = null;
        switch (i1) {
            default:
            case "1": {
                System.out.println("1");
                break;
            }
            case "2"+"3":
                System.out.println("2");
                System.out.println("any num except 1,2");
        }
        System.out.println("...done");
        //endregion

        //region loops
        for (int i = 0, j = 0; i <= 9; i++, j++) {
            System.out.println(i);
        }

        range(0, 10).forEach(System.out::println);

        outer: while (alwaysTrue()) {
            do {
                //
                if (condition()) break outer;
                //
            } while (true);
        }


        int[] array = {1,2,3,4,5};
        for (int current : array) {
            System.out.println(current);
        }

        //endregion
    }

    private static boolean condition() {
//        doSuperLogic();
        //....
//        dbRequest();
        //....
        //....
        return false;
    }


    private static boolean alwaysTrue() {
        return true;
    }


    private void codeBlockException(int arg) {
//        if (arg == 0) return 5;
//        if (arg != -1) return 6;
//        if (arg != -1) return 6;

        //.....
        //.....
        //.....
        //.....
        //.....

        //==========

        if (arg != 0) {
            if (arg == -1) {
                //.......
                //.......
                //.......
                //.......
            } else {
                return;
            }
        } else {
            return;
        }
    }
}
