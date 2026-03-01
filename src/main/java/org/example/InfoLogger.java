package org.example;

public class InfoLogger extends AbstractLogger{
    InfoLogger(LogLevel level){
        super(level);
    }

    @Override
    public void displayLog(String message, LogSubject logSubject){
        String logMessage = "INFO: " + message;
        logSubject.notifyLogObservers(LogLevel.INFO.getLevel(),logMessage);
    }
}
