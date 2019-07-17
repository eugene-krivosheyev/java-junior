package com.acme.edu.ooad;

public enum SeverityLevel {
    INFO(1000), DEBUG(2000), ERROR(3000);

    private int otherCode;

    SeverityLevel(int otherCode) {
        this.otherCode = otherCode;
    }

    public int getOtherCode() {
        return otherCode;
    }
}

final class SevLevel {
    public static final SevLevel INFO = new SevLevel("INFO", 1);
    public static final SevLevel DEBUG = new SevLevel("DEBUG", 2);

    //=============

    private String name;
    private int ordinal;

    private SevLevel(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }


}
