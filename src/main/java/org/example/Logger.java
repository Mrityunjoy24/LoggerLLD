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

    public void createLog(int level, String message){
        chainOfLoggers.log(level,message, logSubject);
    }

    public void info(String message){
        createLog(1, message);
    }

    public void error(String message){
        createLog(2, message);
    }

    public void debug(String message){
        createLog(3, message);
    }
}


