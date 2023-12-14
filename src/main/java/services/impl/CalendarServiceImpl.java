package services.impl;

import dao.CalenderDao;
import exception.EventNotFoundException;
import model.Calendar;
import model.Event;
import model.Shift;
import services.CalendarService;
import services.EventService;
import services.ShiftService;

import java.util.Date;
import java.util.List;

public class CalendarServiceImpl implements CalendarService {

    private final CalenderDao calenderDao;
    private final ShiftService shiftService;
    private final EventService eventService;

    public CalendarServiceImpl(CalenderDao calenderDao, ShiftService shiftService, EventService eventService) {
        this.calenderDao = calenderDao;
        this.shiftService = shiftService;
        this.eventService = eventService;
    }

    public Calendar getCalendar(int userId, String dateStr) {
        return calenderDao.getCalendar(userId, dateStr);
    }

    @Override
    public Calendar createCalendar(int userId, String dateStr) {
        return calenderDao.createCalendar(userId, dateStr);
    }

    @Override
    public Calendar addShift(int userId, Date startTime, Date endDateTime) {
        Shift shift = shiftService.createShift(userId, startTime, endDateTime);
        return calenderDao.addShift(shift);
    }

    @Override
    public List<Calendar> addEvents(List<Integer> userIds, Date startDateTime, Date endDateTime, int createdByuserId) {
        Event cEvent = eventService.createEvent(userIds, startDateTime, endDateTime, createdByuserId);
        return calenderDao.addEvents(cEvent);
    }

    @Override
    public List<Calendar> deleteEvent(int eventId) throws EventNotFoundException {
        Event cEvent = eventService.deleteEvent(eventId);
        return calenderDao.deleteEvent(cEvent);
    }

    @Override
    public List<Calendar> getCalendarForUsers(List<Integer> userIds, String dateStr) {
        return calenderDao.getCalendarForUsers(userIds, dateStr);
    }

}
