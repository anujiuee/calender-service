package utils;

import dao.CalenderDao;
import dao.EventDao;
import dao.ShiftDao;
import services.CalendarService;
import services.EventService;
import services.ShiftService;
import services.impl.CalendarServiceImpl;
import services.impl.EventServiceImpl;
import services.impl.ShiftServiceImpl;

public class CalendarObjProvider {

    public static CalendarService createCalendarService() {
        CalenderDao calenderDao = new CalenderDao();
        ShiftService shiftService = new ShiftServiceImpl(new ShiftDao());
        EventService eventService = new EventServiceImpl(new EventDao());
        CalendarService calendarService = new CalendarServiceImpl(calenderDao, shiftService, eventService);
        return calendarService;
    }
}
