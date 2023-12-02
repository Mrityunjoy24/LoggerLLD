package org.example;

public class ConsoleLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("Console: " + message);
    }
}
