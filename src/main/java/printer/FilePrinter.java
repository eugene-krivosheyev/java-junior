package printer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilePrinter implements Printer{
    @Override
    public void print(String... strings) {
        Path path = Path.of("log.txt");
        try {
            if (!Files.exists(path)) Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path.toFile(), true))) {
            for (String string : strings) {
                if (string != null) printWriter. println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
