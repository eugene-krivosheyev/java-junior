package demo.ooad;

public abstract class ValidatingSaver implements Saver {
    public ValidatingSaver(int i) {
    }

    @Override
    public Number save(String message) {
        if (message == null) throw new IllegalArgumentException();
        return 0L;
    }
}
