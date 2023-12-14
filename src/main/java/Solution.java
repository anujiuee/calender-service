import model.Calendar;
import services.CalendarService;
import utils.CalendarObjProvider;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws Exception {


        CalendarService calendarService = CalendarObjProvider.createCalendarService();
        calendarService.addShift(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-09-28 14:30:00"),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-09-28 15:30:00"));

        Calendar calendar1 = calendarService.getCalendar(1, "2023-09-28");

        System.out.println(calendar1.getShifts().get(0));

        calendarService.addEvents(new ArrayList<>(java.util.Arrays.asList(1, 2)),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-09-28 14:30:00"),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-09-28 15:30:00"), 1);


        Calendar calendar2 = calendarService.getCalendar(2, "2023-09-28");
        System.out.println(calendar2.getEvents());

        System.out.println(calendarService.getCalendarForUsers(java.util.Arrays.asList(1, 2), "2023-09-28"));


    }
}
