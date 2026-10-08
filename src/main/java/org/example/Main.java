package org.example;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();
        logger.info("This is an information.");
        logger.error("This is an error.");
        logger.debug("This is a debug information.");
        logger.warn("This is a warning.");

        // It's important to shut down the logger to ensure all messages are processed.
        logger.shutdown();
    }
}
