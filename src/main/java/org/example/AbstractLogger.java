package org.example;

public abstract class AbstractLogger{
    private int level;
    private AbstractLogger nextLogLevel;

    public AbstractLogger(int level) {
        this.level = level;
    }

    public AbstractLogger(){}

    public void setNextLogLevel(AbstractLogger nextLogLevel){
        this.nextLogLevel = nextLogLevel;
    }
    public void log(int level, String message, LogSubject logSubject){
        if(this.level == level){
            displayLog(message, logSubject);
        }

        if(nextLogLevel!=null)
            nextLogLevel.log(level,message, logSubject);
    }

    public abstract void displayLog(String message, LogSubject logSubject );
}
