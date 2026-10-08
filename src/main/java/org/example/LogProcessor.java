package org.example;

import java.util.concurrent.BlockingQueue;

public class LogProcessor implements Runnable {
    private final BlockingQueue<LogEvent> queue;
    private final AbstractLogger loggerChain;
    private final LogSubject logSubject;

    public LogProcessor(BlockingQueue<LogEvent> queue, AbstractLogger loggerChain, LogSubject logSubject) {
        this.queue = queue;
        this.loggerChain = loggerChain;
        this.logSubject = logSubject;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                LogEvent event = queue.take(); // Blocks until an event is available
                loggerChain.log(event.getLevel().getLevel(), event.getMessage(), logSubject);
            }
        } catch (InterruptedException e) {
            // Interruption is the signal to shut down.
            // Before exiting, process any remaining items in the queue.
            Thread.currentThread().interrupt(); // Preserve the interrupted status
        }
        // Process any remaining logs after the interruption signal
        drainQueue();
    }

    private void drainQueue() {
        LogEvent event;
        while ((event = queue.poll()) != null) {
            loggerChain.log(event.getLevel().getLevel(), event.getMessage(), logSubject);
        }
    }
}
