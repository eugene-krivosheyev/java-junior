package demo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public strictfp class PrimitivesDemo {
    @NotNull
    private String state;

    public strictfp static void main(String[] args) {
        //region Целые со знаком
        byte b = 1_00; //1 byte, Byte.MAX_VALUE
        short s = 010; //2 byte
        int i = 0x10; //4 bytes
        long l = 10000000000000L; //8 byte
        //endregion

        //region С плавающей точкой
        float f = 0.0000000000000000000000000000000000000001f; //16 byte, IEEE 754?
        double d = -2e-5d; //32 byte
        //endregion

        //region Символы
        char c = '\t'; //\u1234
        System.out.println(c);
        //endregion

        //region Логический
        boolean boo = true | false;
        //endregion

        //region Operators
        //region Casting
        int ii = 1000;
        byte bb = (byte) ii;
        System.out.println(bb);
        //endregion

        //region Арифметические
        System.out.println(1 / 1);
        int counter = 0; counter++;
        counter *= 2;
        System.out.println( 10 % 2 );
        //endregion

        //region Bitwise
        byte i1 = 1, i2 = 4;
        //i1 = 001, i2 = 0100
        System.out.println(i2 >>> 1);
        //endregion

        //region Logical
        boolean b1 = false, b2 = true;
        System.out.println(isB1() && isB2());//and, or, not
        System.out.println(!b1);
        System.out.println(1 == 2);  // > = = =

        Cat cat1 = new Cat(1);
        Cat cat2 = new Cat(1);
        cat1.equals(cat2); // = = =

        System.out.println( isB1() ? 1 : isB2() ? "1" : 2);

        cat1 = null;
        if (cat1 != null) {
            System.out.println(cat1.getId());
        }
        Optional<Cat> maybeCat = Optional.empty();
//        fopen("cdf") or die()
        //endregion
        //endregion

        //region Проблемы
        //region Type Overflow
        byte count = 0;
        for (int j = 0; j < 129; j++) {
            count++;
        }
        System.out.println(count);
        //endregion

        //region Потеря точности
        System.out.println(.1 + .2);
        //endregion

        //region Zero
        //Static Analyzers: PMD, CheckStyle, FindBugs
        System.out.println(1/0); //ArEx: / by zero
        System.out.println(2/0.);
        //endregion
        //endregion
    }

    private static boolean isB2() {
        return false;
    }

    private static boolean isB1() {
        Cat cat = new BlueCat(1);
        cat.????()

        if (cat instanceof BlueCat) {
            BlueCat cat1 = (BlueCat) cat;
            cat1.????
        }
        //LSP
        //1M sloc


        return false;
    }
}

class Cat {
    private int id;
    private String name = "";

    public Cat(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class BlueCat extends Cat {
    public BlueCat(int id) {
        super(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        if (true) throw new IllegalNameException();
        super.setName(name);
    }

    public String getTitul() {
        return null;
    }
}