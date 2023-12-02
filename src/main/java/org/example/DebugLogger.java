package org.example;

public class DebugLogger extends AbstractLogger{

    DebugLogger(int level){
        super(level);
    }

    @Override
    public void displayLog(String message, LogSubject logSubject) {
        String logMessage = "DEBUG: "+ message;
        logSubject.notifyLogObservers(3,logMessage);
    }
}
