package com.acme.edu.demo;

public class EnumDemo {
    public static void main(String[] args) {
        Color color = Color.GLUE;
        System.out.println(Color.valueOf("GREEN"));
    }
}

enum Color {
    RED("#FF0000"), GREEN("#00FF00"), GLUE("hahaha!");

    private String hexColor;

    Color(String hexColor) {
        this.hexColor = hexColor;
    }

    public String getHexColor() {
        return hexColor;
    }

    public String getDecoratedHexColor() {
        return hexColor + "!!!";
    }
}

final class ColorEnum {
    public static final ColorEnum RED = new ColorEnum(0, "RED");
    public static final ColorEnum GREEN = new ColorEnum(1, "GREEN");

    public static ColorEnum[] values() {
        return new ColorEnum[] {RED, GREEN};
    }

    //========

    private int ordinal;
    private String name;

    private ColorEnum(int ordinal, String name) {
        this.ordinal = ordinal;
        this.name = name;
    }
}