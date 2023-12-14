package dao;

import model.Calendar;
import model.Event;
import model.Shift;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalenderDao {

    // <userid<Date,calendar>>
    private final Map<Integer, Map<String, Calendar>> calendarMap = new HashMap<>();

    public Calendar createCalendar(int userId, String dateStr) {
        Calendar calendar = new Calendar(userId, dateStr);
        Map<String, Calendar> dateCalenderMap = new HashMap<>();
        dateCalenderMap.put(dateStr, calendar);
        calendarMap.put(userId, dateCalenderMap);
        return calendar;
    }

    public Calendar getCalendar(int userId, String dateStr) {

        if (!calendarMap.containsKey(userId)) {
            createCalendar(userId, dateStr);
        }

        Calendar calendar = calendarMap.get(userId).get(dateStr);
        return calendar;
    }


    //fetch calender for mutiple user on date
    public List<Calendar> getCalendarForUsers(List<Integer> userIds, String dateStr) {

        List<Calendar> calendars = new ArrayList<>();

        for (int userId : userIds) {
            Calendar calendar = calendarMap.get(userId).get(dateStr);
            calendars.add(calendar);
        }

        return calendars;
    }


    public Calendar addShift(Shift shift) {
        //extract dateString from dateTimestamp
        String date = new SimpleDateFormat("yyyy-MM-dd").format(shift.getStartTime());

        if (!calendarMap.containsKey(shift.getUserId())) {
            Calendar calendar = new Calendar(shift.getUserId(), date);
            Map<String, Calendar> dateCalenderMap = new HashMap<>();
            dateCalenderMap.put(date, calendar);
            calendarMap.put(shift.getUserId(), dateCalenderMap);
        }

        List<Shift> shifts = calendarMap.get(shift.getUserId()).get(date).getShifts();
        shifts.add(shift);
        calendarMap.get(shift.getUserId()).get(date).setShifts(shifts);
        return calendarMap.get(shift.getUserId()).get(date);
    }

    public List<Calendar> addEvents(Event event) {

        String date = new SimpleDateFormat("yyyy-MM-dd").format(event.getStartDateTime());

        List<Calendar> calendars = new ArrayList<>();

        for (int userId : event.getUserIds()) {

            if (!calendarMap.containsKey(userId)) {
                Calendar calendar = new Calendar(userId, date);
                Map<String, Calendar> dateCalenderMap = new HashMap<>();
                dateCalenderMap.put(date, calendar);
                calendarMap.put(userId, dateCalenderMap);
            }

            List<Event> events = calendarMap.get(userId).get(date).getEvents();
            events.add(event);

            calendarMap.get(userId).get(date).setEvents(events);

            calendars.add(calendarMap.get(userId).get(date));
        }

        return calendars;
    }

    public List<Calendar> deleteEvent(Event event) {

        String date = new SimpleDateFormat("yyyy-MM-dd").format(event.getStartDateTime());

        List<Calendar> calendars = new ArrayList<>();

        for (int userId : event.getUserIds()) {
            List<Event> events = calendarMap.get(userId).get(date).getEvents();
            events.remove(event);
            calendarMap.get(userId).get(date).setEvents(events);
            calendars.add(calendarMap.get(userId).get(date));
        }

        return calendars;
    }


}
