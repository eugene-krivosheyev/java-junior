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
}
