package com.acme.edu.creatation;

@Component
@Request
public class FileSaver implements Saver {
    private String fileName;

    public FileSaver(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save() {

    }
}
