package services.impl;

import dao.EventDao;
import exception.EventNotFoundException;
import model.Event;
import services.EventService;

import java.util.Date;
import java.util.List;

public class EventServiceImpl implements EventService {

    private final EventDao eventDao;

    public EventServiceImpl(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public Event getEvent(int eventId) throws EventNotFoundException {
        return eventDao.getEvent(eventId);
    }


    @Override
    public Event deleteEvent(int eventId) throws EventNotFoundException {
        return eventDao.deleteEvent(eventDao.getEvent(eventId));
    }

    @Override
    public Event createEvent(List<Integer> userIds, Date startDateTime, Date endDateTime, int createdByuserId) {
        Event event = new Event(userIds, startDateTime, endDateTime, createdByuserId);
        eventDao.createEvent(event);
        return event;
    }
}
