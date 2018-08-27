package enums;

public class EnumsDemo {
    public static void main(String[] args) {
        Color color = Color.RED;
        EnumColor red = EnumColor.RED;
        System.out.println(red.name() + red.ordinal());
        System.out.println(EnumColor.values());
        EnumColor.valueOf("RED");
    }
}

enum EnumColor {
    RED, GREEN, BLUE
}

class Color {
    static final Color RED = new Color(1, "RED");
    static final Color GREEN = new Color(2, "GREEN");
    static final Color BLUE = new Color(3, "BLUE");

    public static Color[] values() {
        return new Color[] {RED, GREEN, BLUE};
    }

    //==================================

    private int ordinal;
    private String name;
    private Color(int ordinal, String name) {
        this.ordinal = ordinal;
        this.name = name;
    }

    public int getOrdinal() {
        return ordinal;
    }
}

class BlankFinalDemo {
    private final int field; //blank final

    public BlankFinalDemo(int field) {
        this.field = field;
    }

    public BlankFinalDemo() {
        field = 0;
    }
}