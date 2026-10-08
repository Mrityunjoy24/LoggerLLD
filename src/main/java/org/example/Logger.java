package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.example.LogManager.buildChainOfLoggers;
import static org.example.LogManager.buildLogSubject;

public class Logger {
    private static volatile Logger logger = null;
    private final BlockingQueue<LogEvent> queue;
    private final ExecutorService executor;

    private Logger() {
        this.queue = new LinkedBlockingQueue<>();
        AbstractLogger chainOfLoggers = buildChainOfLoggers();
        LogSubject logSubject = buildLogSubject();
        LogProcessor logProcessor = new LogProcessor(queue, chainOfLoggers, logSubject);
        this.executor = Executors.newSingleThreadExecutor();
        this.executor.submit(logProcessor);
    }

    public static Logger getInstance() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    public void createLog(LogLevel level, String message) {
        try {
            queue.put(new LogEvent(level, message));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void info(String message) {
        createLog(LogLevel.INFO, message);
    }

    public void error(String message) {
        createLog(LogLevel.ERROR, message);
    }

    public void debug(String message) {
        createLog(LogLevel.DEBUG, message);
    }

    public void warn(String message) {
        createLog(LogLevel.WARN, message);
    }

    public void shutdown() {
        executor.shutdown();
        try {
            // Wait a reasonable amount of time for existing tasks to finish
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // Force shutdown
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
