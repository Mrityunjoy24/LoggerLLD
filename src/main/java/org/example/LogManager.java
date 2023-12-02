package org.example;

public class LogManager {
    public static AbstractLogger buildChainOfLoggers(){
        AbstractLogger infoLogger = new InfoLogger(1);
        AbstractLogger errorLogger = new ErrorLogger(2);
        AbstractLogger debugLogger  = new DebugLogger(3);

        infoLogger.setNextLogLevel(errorLogger);
        errorLogger.setNextLogLevel(debugLogger);

        return infoLogger;
    }


    public static LogSubject buildLogSubject(){

        LogObserver consoleLogger = new ConsoleLogger();
        LogObserver fileLogger = new FileLogger();

        LogSubject logSubject = new LogSubject();

        logSubject.register(1, consoleLogger);
        logSubject.register(1, fileLogger);

        logSubject.register(2, consoleLogger);
        logSubject.register(3, fileLogger);

        return logSubject;
    }
}
