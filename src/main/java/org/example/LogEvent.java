package org.example;

public class LogEvent {
    private final LogLevel level;
    private final String message;

    public LogEvent(LogLevel level, String message) {
        this.level = level;
        this.message = message;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}
