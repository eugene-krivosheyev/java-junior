package com.acme.edu;

import exceptions.SaverException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Stream;

public class FileSaver implements Saver {

    private static final String LOG = "log";
    private String fileName = "";
    private int logFilesNumber;
    private int logLinesNumber = 0;
    private int fileSize;
    private int existingLogFiles = 0;
    private DateTimeFormatter format = DateTimeFormatter
            .ofPattern("yyyy-MM-dd_HH-mm-ss-SSS")
            .withZone(ZoneId.systemDefault());

    FileSaver(final int logFilesNumber,final  int fileSize) {
        this.logFilesNumber = logFilesNumber;
        this.fileSize = fileSize;

    }

    @Override
    public void save(String decoratedString) {

        if (existingLogFiles == 0) {
            fileName = LOG + "_" + format.format(Instant.now());
            new File( fileName + ".txt");
            existingLogFiles++;
        } else if (logLinesNumber >= fileSize) {
            doRotation();
        }

        try (final PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                new FileOutputStream(fileName + ".txt", true))))) {
// todo have a look at BufferedFileWriter
            out.println(decoratedString);
            logLinesNumber++;

        } catch (IOException e) {

            // todo rethrow exceptions
            e.printStackTrace();
            throw new SaverException(e);
        }
    }

    private void doRotation() {

        fileName = LOG + "_" + format.format(Instant.now());
        existingLogFiles++;
        logLinesNumber = 0;
        if (existingLogFiles > logFilesNumber) {

            Path currentRelativePath = Paths.get("");

            try (Stream <Path> paths = Files.walk(currentRelativePath, 1)) {
                Optional <File> fileForDeletion = paths
                        .map(Path::toFile)
                        .filter(f -> f.getName().startsWith(LOG))
                        .min((f1, f2) -> {
                            long f1LastModified = f1.lastModified();
                            long f2LastModified = f2.lastModified();

                            if (f1LastModified == f2LastModified) {
                                return 0;
                            }

                            return f1LastModified > f2LastModified ? 1 : -1;
                        });

                System.out.println(fileForDeletion);

                //noinspection ResultOfMethodCallIgnored
                fileForDeletion.ifPresent(File::delete);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
