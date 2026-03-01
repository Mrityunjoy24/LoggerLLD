package org.example;

public class ErrorLogger extends AbstractLogger{

    ErrorLogger(LogLevel level){
        super(level);
    }
    @Override
    public void displayLog(String message, LogSubject logSubject) {
        String logMessage = "ERROR: "+ message;
        logSubject.notifyLogObservers(LogLevel.ERROR.getLevel(),logMessage);
    }
}
