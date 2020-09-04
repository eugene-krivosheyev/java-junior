package demo;

public class OperatorsDemo {
    public static void main(String[] args) {
        //region Arithmetics operators
        System.out.println( 0. / 0 );
        //endregion

        //region Bitwise
        System.out.println( 1 ^ 2 ); // & | ^ ~
        System.out.println( 2 >>> 1 ); // << >> >>>
        //endregion

        //region Logical
        System.out.println(false && false); // & | !
        System.out.println(true || false);
        System.out.println(m1() || m2());
        // fopen("fff") or die();
        //endregion
        //region Compare
        System.out.println( 1 > 2 ); // > < >= <= == !=
        //endregion
        //region Ternary
        System.out.println(  1 == 1 ? "yes" : 3  );
        System.out.println( 1 == 1 ? (2 != 3 ? 1 : 2) : 8 );
        //endregion
        System.out.println("qqq".equals("qqq"));
    }

    private static boolean m2() {
        return false;
    }

    private static boolean m1() {
        return true;
    }
}
