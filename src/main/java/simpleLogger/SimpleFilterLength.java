package simpleLogger;

public class SimpleFilterLength implements SimpleFilter {
    private int length;

    public SimpleFilterLength(int length){
        this.length = length;
    }

    @Override
    public boolean filter(String message) {
        return message.length() < length;
    }
}
