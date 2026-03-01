package org.example;

public class WarnLogger extends AbstractLogger{

    WarnLogger(LogLevel level){
        super(level);
    }
    @Override
    public void displayLog(String message, LogSubject logSubject) {
        String logMessage = "WARN: "+ message;
        logSubject.notifyLogObservers(LogLevel.WARN.getLevel(),logMessage);
    }
}
