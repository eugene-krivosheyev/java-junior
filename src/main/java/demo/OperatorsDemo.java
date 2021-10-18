package demo;

import java.util.Objects;

public class OperatorsDemo {
    public static void main(String[] args) {
        //region арифметические
        byte b1 = 0, b2 = 0;
        // binary: + - * / %
        // unary: - ++ --; += -= *= /= %=

        //byte bb = b1 + b2;
        b1 += 1;
        System.out.println( 0/0. );
        //endregion

        //region побитовые
        int i1 = 0, i2 = 0;
        System.out.println( i1 | i2 );
        System.out.println( i1 & i2 );
        System.out.println( i1 ^ i2 );
        System.out.println( ~i2 );

        System.out.println( i1 >> 1);
        System.out.println( i1 >>> 2);
        System.out.println( i1 << 1);
        //endregion

        //region сравнения
        // == != > < >= <=
        // ternary
        String result = 1 == 1 ? "yep!!" : "nope!!";
        //endregion

        //region логические
        boolean boo1 = true, boo2 = false;
        System.out.println( boo1 && boo2 );
        System.out.println( boo1 || boo2 );
        System.out.println( !boo2 );

        System.out.println( f1() && f2() );
        Objects.equals(null, "a");

        // fopen('a.txt') && die();

        //endregion
    }

    private static boolean f1() {
        return false;
    }

    private static boolean f2() {
        return false;
    }
}
