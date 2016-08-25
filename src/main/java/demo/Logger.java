package demo;

public class Logger {
    /**
     * Creational Patterns
     */
    private final Filter filter; //DI
    private final Saver saver = SaverFactory.create();

    public Logger(Filter filter) {
        this.filter = filter;
    }

    public void log(String message) {
        if (filter.filter(message)) {
            saver.save(message);
        }

        System.out.println(Color.BLUE);
    }
}

enum Color {
    RED, GREEN, BLUE, MY;

}

final class MyColor {
    private int ordinal;

    public static final MyColor RED = new MyColor(0);
    public static final MyColor GREEN = new MyColor(1);
    public static final MyColor BLUE = new MyColor(2);

    MyColor(int ordinal) {
        this.ordinal = ordinal;
    }
}


