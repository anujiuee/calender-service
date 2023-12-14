package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Calendar {

    //autoIncrement
    private int calendarId;
    private int calendarIdIndex;
    private int userId;
    private String dateStr;
    private List<Event> events;
    private List<Shift> shifts;
    private Date createdAt;

    public Calendar(int userId, String dateStr) {
        this.calendarId = calendarIdIndex++;
        this.userId = userId;
        this.dateStr = dateStr;
        this.events = new ArrayList<>();
        this.shifts = new ArrayList<>();
        this.createdAt = new Date();
    }

    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "calendarId=" + calendarId +
                ", calendarIdIndex=" + calendarIdIndex +
                ", userId=" + userId +
                ", date=" + dateStr +
                ", events=" + events +
                ", shifts=" + shifts +
                ", createdAt=" + createdAt +
                '}';
    }
}
