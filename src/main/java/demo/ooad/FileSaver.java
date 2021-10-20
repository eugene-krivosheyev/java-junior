package demo.ooad;

import java.util.Date;

public class FileSaver extends ValidatingSaver {
    private final String FILE_NAME;

    {
        System.out.println("ку-ку");
    }

    public FileSaver() {
//        super() ^ this()
        this("default.txt");
    }

    public FileSaver(String fileName) {
        super(0);
        this.FILE_NAME = fileName;
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
