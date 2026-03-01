package org.example;

import static org.example.LogManager.buildChainOfLoggers;
import static org.example.LogManager.buildLogSubject;

public class Logger {
    private static Logger logger = null;
    private static AbstractLogger chainOfLoggers = null;

    private static LogSubject logSubject = null;
    private Logger(){
    }

    public static Logger getInstance(){
        if(logger==null){
            logger = new Logger();
            chainOfLoggers = buildChainOfLoggers();
            logSubject = buildLogSubject();
        }

        return logger;
    }

    public void createLog(LogLevel level, String message){
        chainOfLoggers.log(level.getLevel(),message, logSubject);
    }

    public void info(String message){
        createLog(LogLevel.INFO, message);
    }

    public void error(String message){
        createLog(LogLevel.ERROR, message);
    }

    public void debug(String message){
        createLog(LogLevel.DEBUG, message);
    }

    public void warn(String message){
        createLog(LogLevel.WARN, message);
    }
}
