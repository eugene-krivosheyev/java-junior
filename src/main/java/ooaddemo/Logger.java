package ooaddemo;


final class Logger {
    //Creator
    private final LoggerFilter filter = new MessageContentLoggerFilter();
    private final LoggerSaver saver;

    //Dependency Injection: constructor | setter
    public Logger(final LoggerSaver saver) {
        this.saver = saver;
    }

    /**
     * OCP: Open Closed Principle
     * DIP: Dependency Inversion Principle
     */
    public final void log(String message) {
        if (!filter.filter(message)) {
            saver.save(message);

            Color2.B.getColorCode();
        }
    }
}

final class Color {
    private int ordinal;
    private Color(int ordinal) {
        this.ordinal = ordinal;
    }

    public static final Color R = new Color(1);
    public static final Color G = new Color(2);
    public static final Color B = new Color(3);

    public static Color[] values() {
        return new Color[] {R, G, B};
    }

}

enum Color2 {
    R(0xFF0000), G(0x00FF00), B(0x0000FF);

    private int colorCode;
    Color2(int colorCode) {
        this.colorCode = colorCode;
    }

    public int getColorCode() {
        return colorCode;
    }

    public void doBusinessLogic() {

    }
}
