package demo;

/**
 * Created by Ivan on 27.09.2017.
 */

//strictfp - строго по стандарту 754
    //для float double
    //для классов и методов
    //после модификатора видимости
public class PrimitivesDemo {
    int i; //хранится в heap
    public static void main(String[] args) {
        //region Целые со знаком
        byte b = 0; //1 byte, Byte.MAX_VALUE
        short s = 0;//2 byte
        int i = 0;//4 byte //хранится в stack
        long l = 0;//8 byte
        //endregion
        //region С плавающей точкой
        float f = 0.f;//16 byte
        double d = 0;//0. -2e5=-2*(10^5)    32 byte
        //endregion
        //region Символы
        char c = 100;//'w','\uAAAA', '\t'
        //endregion
        //region Логический
        boolean boo = true | false;

        //endregion

        //region Operators
        //region Casting
        int ii =100;
        byte bb = (byte) ii;
        //endregion
        //System.load();System.loadLibrary(); подключение библиотек
        //region Арифметические
        //не естействуйте мозг
        //endregion
        //region Битовые
        int i1 = 1, i2 = 2;
        System.out.println(i1 & i2);
        System.out.println(i1 | i2);
        System.out.println(i1 ^ i2);
        System.out.println(~i2);
        System.out.println(i2 << 1); //эквивалентно умножению на 2

        System.out.println(i1 >> 2); //эквивалентно делению на 4
        System.out.println(i1 >>> 2); //при сдвиге будет дублироваться первый слева символ(второй операнд ведется по модуюлю 32)

        //endregion Lo
        //region Logical
        boolean b1 = false, b2 = true;
        System.out.println(b1||b2);//and &&(&), or ||(|), not !
        System.out.println(1 != 2);
        System.out.println(b1?"1":"2");

        //endregion
        //endregion

        //region Проблемы
        //region Переполнение
        byte count = 0;
        for (int j = 0; j < 129; j++) {
            count++;
        }
        System.out.println(count);
        //endregion
        //region Потеря точности
        System.out.println(1/3.);
        System.out.println(.1+.2);
        //endregion
        //region Zero
        //static analizator: PMD, CheckStyle, FindBugs
        System.out.println(1/0); //ArEx: /by zero
        System.out.println(1/0.); //Double.POSITIVE_INFINITY
        //endregion
        //endregion
    }
}
