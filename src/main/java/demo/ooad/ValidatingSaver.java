package demo.ooad;

public abstract class ValidatingSaver implements Saver {
    @Override
    public Number save(String message) {
        if (message == null) throw new IllegalArgumentException();
        return 0L;
    }
}
