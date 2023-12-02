package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject {
    public Map<Integer, List<LogObserver>> logObservers = new HashMap<>();

    public void register(int level, LogObserver logObserver){
        List<LogObserver> observerListByLevel = logObservers.getOrDefault(level,new ArrayList<>());
        observerListByLevel.add(logObserver);
        logObservers.put(level, observerListByLevel);
    }

    public void notifyLogObservers(int level, String message){
        List<LogObserver> observerListByLevel = logObservers.get(level);

        for(LogObserver logObserver : observerListByLevel){
            logObserver.log(message);
        }
    }
}
