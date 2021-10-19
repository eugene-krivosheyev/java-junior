package demo.ooad;

public class FileSaver implements Saver {
    private final String FILE_NAME;

    public FileSaver(String fileName) {
        FILE_NAME = fileName;
    }

    public void save(String message) {
        System.out.println("write " + message + " to file " + FILE_NAME);
    }

    public void close() {

    }
}
