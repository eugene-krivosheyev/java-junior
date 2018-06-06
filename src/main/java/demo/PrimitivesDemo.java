package demo;

public class PrimitivesDemo {
    public static void main(String[] args) {
        //region Примитивные = 8
        //region Целочисленные
        byte b = -022; //-128..127;
        short s = 1_000; // ≥ 7
        int i = 1_0_0_0_0_0_0;
        long l = 1000000000000000L; //JMM
        System.out.println(Integer.MIN_VALUE);
        //endregion
        //region С плавающей точкой
        float f = 0.F; //32 bit -> 4 bytes
        double d = -2e-5; //64 bit -> 8 bytes
        System.out.println(1./3);
        //endregion
        //region Символьный тип
        char c = '\u55FF'; //Unicode symbol: 2 bytes
        System.out.println('\r' + '\n' + c);
        System.out.println(System.lineSeparator());
        // c:\dir1\dir <-> /dir1/dir2
        //cp = dir1;dir2 <-> cp = dir1:dir2
        //endregion
        //region Логический
        boolean b1 = true | false;
//      boolean b2 = 0;
        // # DEFINE true false
        //endregion
        //endregion

        //region Операторы
        //region Casting
        byte bb = 0;
        int ii = 129;
        bb = (byte) ii; //Потеря данных
        System.out.println("(): " + bb);
        //endregion
        //region Arithmetic
        System.out.println(1 / 2);
        System.out.println(-1 + 2 + "3" + 4 * 5);
        int iii = 0;
        iii += 0; //iii = iii + 1
        System.out.println(--iii);
        System.out.println(iii++);
        //endregion
        //region Bitwise
        int i1 = 1, i2 = 2;
        System.out.println(i1 & i2); //*
        System.out.println(i1 | i2); //+
        System.out.println(i1 ^ i2); //xor
        System.out.println(~i2); //not
        System.out.println(i1 >> 1); //unsigned shift
        System.out.println(i1 >>> 1); //signed shift
        System.out.println(i1 << 1); //left shift
        //endregion
        //region Logic
        boolean isUserLogged = true, moonInJupiter = false;
        boolean unseccessCase = isUserLogged && moonInJupiter;
        System.out.println(unseccessCase); //*
        System.out.println(isUserLogged || moonInJupiter); //+

        System.out.println(f1() || f2());
        // fopen('ddd') or die();
        System.out.println(!moonInJupiter);
        //endregion
        //region Ternary Operator
        String myCase = unseccessCase ? "OOOK" : "non Ok";
        System.out.println( isUserLogged ? myCase : 4 );
        //endregion
        //endregion

        //region Проблемы
        //region Type Overflow
        //endregion
        //region Precision Loss
        System.out.println(.1 + .2);
        //endregion
        //endregion

        //region Ссылочные
        //endregion
    }

    private static boolean f2() {
        return false;
    }

    private static boolean f1() {
        return false;
    }
}
