package demo.operators;

import java.util.Objects;

public class OperatorsDemo {
    public static void main(String[] args) {
        //region arith operators
//        System.out.println(0 / 0.); //NaN
//        System.out.println(1 / 0);
//        System.out.println(10 % 3);
        //endregion

        //region bitwise operators
        int a = 1, b = 2;
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);
        System.out.println(~b); // != !
        System.out.println(a >> 1);
        System.out.println(a >>> 1);
        System.out.println(a << 1);
        //endregion

        //region logic operators
        System.out.println(f1() & f2()); //long-circit, eager
        System.out.println(true | false);
        System.out.println(f1() && f2()); //lazy
//        fopen('aaa') or die();
        System.out.println(true || false);
        System.out.println(!false);
        //endregion

        //region comparation
        System.out.println(1 >= 2);
        System.out.println(1 != 2);
        System.out.println(1 == 2);
        System.out.println("1".equals("2"));
        System.out.println(Objects.equals("1", "2"));

        Object result = f1() ? a < b ? 0 : 1 : 1;
        //endregion

        //region ветвления
        if (a == b) {
            System.out.println("2");
        } else if (a != b) {

        } else //TODO JCSC!!!
            System.out.println("1");

        String ii = null;
        switch (ii) {
            case "0":
                System.out.println(00);
                System.out.println(01);
                break;
            case "1":
                System.out.println(10);
                System.out.println(11);
                break;
            default:
                System.out.println("any");
        }

        for (int counter = 0, j = 0; counter < 10; counter++, j--) {
            System.out.println(counter);
        }

        while (f1()) {

        }

        do {

        } while (f1());

        //for-each: arrays & Iterable
        for (String current : args) {
            System.out.println(current);
        }
        //kSLoC
        //Cyclomatic Complexity:
        //overall = 2564 -> dynamic + hotspots
        //per method = 1.3 + gistogram
        //KILL not-natural complexity!

        outer: while (f2()) {
            inner: while (f1()) {
                continue outer;
//                break outer;
            }
        }
        //endregion
    }

    private static boolean f2() {
        boolean killPeople;
        boolean p2 = false;

        //Guard clause:
        if (killPeople = true) return false;
        if (p2 == false) throw new IllegalArgumentException();

        return false;
    }

    private static boolean f1() {
        return false;
    }


}
