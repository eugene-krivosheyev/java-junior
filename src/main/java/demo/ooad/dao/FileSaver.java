package demo.ooad.dao;

import demo.ooad.domain.Message;
import demo.ooad.validator.EmptynessValidator;

public class FileSaver extends AbstractCheckingSaver {
    private final String fileName;

    public FileSaver(String fileName) {
        super(new EmptynessValidator());
        this.fileName = fileName;
    }

    @Override
    public void save(Message message) {
        super.save(message);

        System.out.println(
                "saving message " + message +
                "to file " + fileName
        );
    }
}
