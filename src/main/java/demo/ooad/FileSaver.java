package demo.ooad;

import java.util.Date;

public class FileSaver extends ValidatingSaver {
    private final String FILE_NAME;

    @SuppressWarnings("")
    public FileSaver(String fileName) {
        FILE_NAME = fileName;
    }

    @Override
    public Long save(String message) {
        super.save(message);
        System.out.println("write " + message + " to file " + FILE_NAME);
        return 0L;
    }

    @Deprecated
    public void close() {
        this.save("");
    }
}
