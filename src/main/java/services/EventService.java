package services;

import exception.EventNotFoundException;
import model.Event;

import java.util.Date;
import java.util.List;

public interface EventService {

    Event getEvent(int eventId) throws EventNotFoundException;

    Event deleteEvent(int eventId) throws EventNotFoundException;

    Event createEvent(List<Integer> userIds, Date startDateTime, Date endDateTime, int createdByuserId);
}
