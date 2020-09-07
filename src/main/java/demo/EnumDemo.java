package demo;

public class EnumDemo {
    public static void main(String[] args) {
        final MyColor green = MyColor.RED.GREEN;

        MyColor currentColor = MyColor.RED;
        currentColor.getOrdinal();

        Color.GREEN.ordinal();
        final Color color = Color.valueOf("GREEN");
        final Color[] enumValues = Color.values();
    }
}

enum Color {
    RED, BLUE, GREEN, GRAY
}

final class MyColor {
    public static final MyColor RED = new MyColor(1);
    public static final MyColor GREEN = new MyColor(2);
    public static final MyColor BLUE = new MyColor(3);

    // .-.-.-.-.-.-.-.-.-.-.-

    private int ordinal;

    private MyColor(int ordinal) {
        this.ordinal = ordinal;
    }

    public int getOrdinal() {
        return ordinal;
    }
}