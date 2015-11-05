package com.acme.edu.printer;

import javafx.fxml.LoadException;

/**
 * Data output
 */
public interface Printable {
    /**
     * print to console
     * @param message
     */
    void print(String message) throws LoadException;
}
