package services;

import exception.EventNotFoundException;
import model.Calendar;

import java.util.Date;
import java.util.List;

public interface CalendarService {

    Calendar getCalendar(int userId, String dateStr);

    Calendar createCalendar(int userId, String dateStr);

    Calendar addShift(int userId, Date startTime, Date endDateTime);

    List<Calendar> addEvents(List<Integer> userIds, Date startDateTime, Date endDateTime, int createdByuserId);

    List<Calendar> deleteEvent(int eventId) throws EventNotFoundException;

    List<Calendar> getCalendarForUsers(List<Integer> userIds, String dateStr);
}
