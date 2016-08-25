package demo;

/**
 * Created by eugene on 24.08.16.
 */
public class SaverFactory {
    public static Saver create() {
        return new ConsoleSaver();
    }
}
