package org.example;

public enum LogLevel {
    ERROR(1),
    WARN(2),
    INFO(3),
    DEBUG(4);

    private final int level;

    LogLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
