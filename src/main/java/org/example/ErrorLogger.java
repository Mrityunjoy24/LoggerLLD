package org.example;

public class ErrorLogger extends AbstractLogger{

    ErrorLogger(int level){
        super(level);
    }
    @Override
    public void displayLog(String message, LogSubject logSubject) {
        String logMessage = "ERROR: "+ message;
        logSubject.notifyLogObservers(2,logMessage);
    }
}
