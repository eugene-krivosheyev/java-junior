package com.acme.edu.demo;

import java.util.Objects;

import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;

public class OperatorsDemo {
    public static void main(String[] args) {
        //region Arithmetic
//        System.out.println(0 / 0);

        System.out.println(null == null);
        System.out.println(null != null);
        System.out.println(Objects.equals(null, null));
        System.out.println(null instanceof Object);

        System.out.println(NaN == NaN);
        System.out.println(POSITIVE_INFINITY == POSITIVE_INFINITY);
        //endregion

        //region Bitwise
        //&, |, ~,
        System.out.println(Integer.toBinaryString(~2));
        System.out.println((~2));
        System.out.println(1 << 3);
        System.out.println(1 >>> 33); // 33 mod 32
        //endregion

        //region Logical
        boolean b1 = true, b2 = false;
        System.out.println(b1 & b2());
        System.out.println(b1 | b2());
        System.out.println(b1 && b2());
        System.out.println(b1 || b2());
        System.out.println(b1 ^ b2);
        System.out.println(!b2);
        //fopen("") or die();

        System.out.println(1 >= 1);

        String s1 = "a", s2 = "a";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        s1.equals("const"); //->
        "const".equals(s1);
        Objects.equals(s1, s2);

        //region Ternary
        Object result = 1 > 2 ? 2 < 3 ? 4 : 5 : "2";
        //endregion
        //endregion
    }

    private static boolean b2() {
        return false;
    }
}
