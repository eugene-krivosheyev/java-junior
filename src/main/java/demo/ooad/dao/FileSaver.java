package demo.ooad.dao;

import demo.ooad.domain.Message;
import demo.ooad.validator.EmptynessValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class FileSaver extends AbstractCheckingSaver {
    private final String fileName;

    public FileSaver(String fileName) {
        super(new EmptynessValidator());
        this.fileName = fileName;
    }

    @Override
    public void save(Message message) throws SaveException  {
        super.save(message);

//        System.out.println(
//                "saving message " + message +
//                "to file " + fileName
//        );

        try {
            Files.writeString(Paths.get("file.txt"), message.toString(), CREATE);
        } catch (IOException e) {
            throw new SaveException(e);
        }
    }
}
