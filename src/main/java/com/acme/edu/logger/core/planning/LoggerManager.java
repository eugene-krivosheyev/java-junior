package com.acme.edu.logger.core.planning;

import com.acme.edu.logger.core.control.LoggerController;
import com.acme.edu.logger.core.output.LoggerOutput;

/**
 * Manager for configure and planning workflow of loggers.
 */
public class LoggerManager {

    /**
     * Main workflow controller.
     */
    private static LoggerController controller = new LoggerController();

    /**
     * Main logger output.
     */
    private static LoggerOutput output = new LoggerOutput();

    /**
     * Get active output of logger work.
     * @return active output.
     */
    public String getActiveOutput() {
        return output.getActiveString();
    }

    /**
     * Get complete output of logger work.
     * @return complete output.
     */
    public String getCompleteOutput() {
        return output.getCompleteString();
    }

    /**
     * Get active logger controller.
     * @return logger controller.
     */
    public LoggerController getController() {
        return controller;
    }
}
