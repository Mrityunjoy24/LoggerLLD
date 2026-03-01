package org.example;

public class DebugLogger extends AbstractLogger{

    DebugLogger(LogLevel level){
        super(level);
    }

    @Override
    public void displayLog(String message, LogSubject logSubject) {
        String logMessage = "DEBUG: "+ message;
        logSubject.notifyLogObservers(LogLevel.DEBUG.getLevel(),logMessage);
    }
}
