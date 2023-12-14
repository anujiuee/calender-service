package dao;

import exception.EventNotFoundException;
import model.Event;

import java.util.HashMap;
import java.util.Map;

public class EventDao {

    private final Map<Integer, Event> eventMap = new HashMap<>();

    public Event getEvent(int eventId) throws EventNotFoundException {

        if (!eventMap.containsKey(eventId)) {
            throw new EventNotFoundException("event not exist");
        }

        return eventMap.get(eventId);
    }

    public Event createEvent(Event event) {
        return eventMap.put(event.getEventId(), event);
    }

    public Event deleteEvent(Event event) {
        eventMap.remove(event.getEventId());
        return event;
    }
}
