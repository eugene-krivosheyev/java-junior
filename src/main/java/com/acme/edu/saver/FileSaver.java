package com.acme.edu.saver;

import com.acme.edu.exception.SaveException;
import com.acme.edu.message.Message;

import java.io.*;

public class FileSaver implements Saver {

    @Override
    public void save(Message message) throws SaveException {
//        try (RandomAccessFile randomAccessFile = new RandomAccessFile("output.txt", "rw")) {
//            randomAccessFile.writeUTF(message.getDecoratedString());
//        } catch (FileNotFoundException e) {
//            throw new SaveException(e);
//        } catch (IOException e) {
//            throw new SaveException(e);
//        } catch (Exception e) {
//            throw new SaveException(e);
//        }

        File file = new File(".", "output.txt");
        try (PrintWriter printWriter =
                     new PrintWriter(
                             new OutputStreamWriter(
                                     new BufferedOutputStream(
                                             new FileOutputStream(
                                                     file,
                                                     true)
                                     )
                             )
                     )
        )
        {
            printWriter.println(message.getDecoratedString());
        } catch (IOException e) {
            throw new SaveException(e);
        }
    }
}
