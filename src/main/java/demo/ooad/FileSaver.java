package demo.ooad;

public class FileSaver extends ValidatingSaver {
    private final String FILE_NAME;

    public FileSaver(String fileName) {
        FILE_NAME = fileName;
    }

    //overriding
    public Long save(String message) {
        super.save(message);
        System.out.println("write " + message + " to file " + FILE_NAME);
        return 0L;
    }

    @Override
    public void close() {

    }
}
