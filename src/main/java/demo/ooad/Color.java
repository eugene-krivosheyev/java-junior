package demo.ooad;

public enum Color {
    RED(0xFF0000), BLUE(0x0000FF), GREEN(0x00FF00);
//    public static final Color RED1 = new Color(0x555);

    private int colorInHex;
    Color(int colorInHex) {
        this.colorInHex = colorInHex;
    }

    public int getColorInHex() {
        return colorInHex;
    }
}

enum DayOfWeek {
    M,T,W,TH,F,SUT,SUN
}

final class OldSchoolColor {
    public static final OldSchoolColor RED = new OldSchoolColor(1, "RED");
    public static final OldSchoolColor GREEN = new OldSchoolColor(2, "GREEN");
    public static final OldSchoolColor BLUE = new OldSchoolColor(3, "BLUE");

    //===================

    private int ordinal;
    private String name;

    private OldSchoolColor(int ordinal, String name) {
        this.ordinal = ordinal;
        this.name = name;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public String getName() {
        return name;
    }
}

class EnumDemo {
    public static void main(String[] args) {
        Color color = Color.RED;
        DayOfWeek day = DayOfWeek.F;

        if (color == Color.RED) {

        }


        OldSchoolColor color1 = OldSchoolColor.RED;
    }
}