package org.example;

public class InfoLogger extends AbstractLogger{
    InfoLogger(int level){
        super(level);
    }

    @Override
    public void displayLog(String message, LogSubject logSubject){
        String logMessage = "INFO: " + message;
        logSubject.notifyLogObservers(1,logMessage);
    }
}
