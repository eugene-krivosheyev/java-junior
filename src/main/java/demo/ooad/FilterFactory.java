package demo.ooad;

public class FilterFactory {
    public static Filter get() {
        return new MessageLengthFilter(100);
    }
}
