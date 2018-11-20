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

        //logic operators
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
    }

    private static boolean f2() {
        return false;
    }

    private static boolean f1() {
        return false;
    }


}
