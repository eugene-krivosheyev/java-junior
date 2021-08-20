package demo;

import java.io.Serializable;
import java.util.Objects;

import static java.lang.Integer.valueOf;

public class OperatorsDemo {
    public static void main(String[] args) {
        //region арифметические
        int i1 = 1, i2 = 1;
        System.out.println(i1); // unary: - + -- ++ (prefix/postfix)
        System.out.println(i1 + i2); // binary: + - * / %
        i1 = i1 + 3; i1 += 3; // operator with assignment

        System.out.println(i1/i2); // 0
        System.out.println(1/3d); // 0

        System.out.println(1 / 0.); // Double.(POSITIVE_)INFINITY
        System.out.println(0 / 0.); // Double.NaN
//        System.out.println(1 / 0);
        //endregion

        //region битовые
        System.out.println(~i1);
        System.out.println(i1 & i2); // & | ^
        System.out.println(i1 >>> 1);
        System.out.println(i1 >> 2);
        System.out.println(i1 << (33 % 32));
        //endregion

        //region logical
        boolean b1 = true, b2 = false;
        System.out.println(!b2); // !
        System.out.println(b1 ^ b2); // & | ^ && ||

        System.out.println(3 != 2); // == != > < >= <=
        System.out.println(valueOf(1).equals(valueOf(2)));
        valueOf(1).compareTo(valueOf(2));

        int ii1 = 0, ii2 = 2;
        System.out.println( ii1 <<= ii2 ); // < < =

        System.out.println(b1() || b2());
        Objects.equals(i1, i2);
        //endregion
        // fopen('a.txt') or die();

        //region ternary
//        Object o = i1 >= 3 ? i2 == 2 ? "a" : 5 : "no";
        String result = i1 >= 0 ? "yes" : "no";
        //endregion
    }

    private static boolean b2() {
        return false;
    }

    private static boolean b1() {
        return false;
    }
}
