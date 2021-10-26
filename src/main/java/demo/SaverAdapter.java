package demo;

import demo.ooad.Saver;

public class SaverAdapter implements Saver {
    @Override
    public Number save(String message) {
        return 0;
    }

    @Override
    public void close() {

    }
}
