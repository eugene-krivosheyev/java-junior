package demo.finalandenumdemo;

import static demo.finalandenumdemo.SeverityLevel.INFO;

public class FinalAndEnumDemo {
    public static void main(String[] args) {
        SeverityLevel severityLevel = INFO;
//        switch (severityLevel) {
//            case INFO: break;
//            default:
//        }

        SeverityLevel severityLevel1 = INFO;
        SeverityLevel severityLevel2 = severityLevel1;
        SeverityLevel severityLevel3 = null;
//        System.out.println(severityLevel3);

//        Color.valueOf("RED");
//        SuperColor.B.getCode();
    }
}

enum Color { RED, GREEN, BLUE }

enum SuperColor {
    R(2550000), G(0025500), B(0000255);

    private int code;
    SuperColor(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

class SeverityLevel {
    public static final SeverityLevel ERROR = new SeverityLevel(1);
    public static final SeverityLevel INFO = new SeverityLevel(2);
    public static final SeverityLevel DEBUG = new SeverityLevel(3);

    public static SeverityLevel[] values() {
        return new SeverityLevel[] {ERROR, INFO, DEBUG};
    }
    //===

    private int ordinal;
    private SeverityLevel(int ordinal) {
        this.ordinal = ordinal;
    }

    public int getOrdinal() {
        return ordinal;
    }
}

class Humanbeing {
//    public static final COUNT = ;
    public static final Humanbeing BUDDHA = new Humanbeing();
    public static final Humanbeing MOSES = new Humanbeing();

    //===

//    private Hand hand;
    private int age;
}

class Car {
    public static final Car FIRST_CAR = new Car();
    public static final Car SECOND_CAR = new Car();
    public static final Car THIRD_CAR = new Car();


    private String vin;


}

