package org.example;

public class LogManager {
    public static AbstractLogger buildChainOfLoggers(){
        AbstractLogger infoLogger = new InfoLogger(LogLevel.INFO);
        AbstractLogger errorLogger = new ErrorLogger(LogLevel.ERROR);
        AbstractLogger debugLogger  = new DebugLogger(LogLevel.DEBUG);
        AbstractLogger warnLogger = new WarnLogger(LogLevel.WARN);

        errorLogger.setNextLogLevel(warnLogger);
        warnLogger.setNextLogLevel(infoLogger);
        infoLogger.setNextLogLevel(debugLogger);

        return errorLogger;
    }


    public static LogSubject buildLogSubject(){

        LogObserver consoleLogger = new ConsoleLogger();
        LogObserver fileLogger = new FileLogger();

        LogSubject logSubject = new LogSubject();

        logSubject.register(LogLevel.INFO.getLevel(), consoleLogger);
        logSubject.register(LogLevel.INFO.getLevel(), fileLogger);

        logSubject.register(LogLevel.ERROR.getLevel(), consoleLogger);
        logSubject.register(LogLevel.DEBUG.getLevel(), fileLogger);
        logSubject.register(LogLevel.WARN.getLevel(), consoleLogger);


        return logSubject;
    }
}
