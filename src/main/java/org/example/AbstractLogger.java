package org.example;

public abstract class AbstractLogger{
    protected LogLevel level;
    private AbstractLogger nextLogLevel;

    public AbstractLogger(LogLevel level) {
        this.level = level;
    }

    public void setNextLogLevel(AbstractLogger nextLogLevel){
        this.nextLogLevel = nextLogLevel;
    }
    
    public void log(int level, String message, LogSubject logSubject){
        if(this.level.getLevel() == level){
            displayLog(message, logSubject);
        }
        else if(nextLogLevel!=null){
            nextLogLevel.log(level,message, logSubject);
        }
    }

    public abstract void displayLog(String message, LogSubject logSubject );
}
