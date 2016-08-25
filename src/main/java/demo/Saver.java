package demo;

public interface Saver {
    public static final int I = 0;
    void save(String message);

    default int getStatus() {
        this.hashCode();
        return 0;
    }

    static int gS() {
        return 0;
    }
}
