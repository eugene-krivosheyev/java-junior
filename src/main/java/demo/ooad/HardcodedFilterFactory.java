package demo.ooad;

public class HardcodedFilterFactory implements FilterFactory {
    @Override
    public Filter get() {
        return new MessageLengthFilter(100);
    }
}
