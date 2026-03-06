package com.messenger.tryingjbdc.EventManager;

import com.messenger.tryingjbdc.DTO.AccountDTO;
import com.messenger.tryingjbdc.Interfaces.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class EventManager {
    Map<String, List<EventListener>> listeners=new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation,new ArrayList<>());
        }
    }

    public <D> void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public <D> void unsubscribe(String eventType, Class<? extends EventListener> listenerClass) {
        List<EventListener> users = listeners.get(eventType);
//        users.remove(listener);
        users.removeIf(listener -> listener.getClass().equals(listenerClass));
    }

    public <D> void notify(String eventType, D data) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, data);
        }
    }

}
