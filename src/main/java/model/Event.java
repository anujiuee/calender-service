package model;

import java.util.Date;
import java.util.List;

public class Event {

    private int eventId;
    private int eventIdIndex;
    private List<Integer> userIds;
    private Date startDateTime;
    private Date endDateTime;
    private Date createdAt;
    private int createdByuserId;

    public Event(List<Integer> userIds, Date startDateTime, Date endDateTime, int createdByuserId) {
        this.eventId = eventIdIndex++;
        this.userIds = userIds;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.createdAt = new Date();
        this.createdByuserId = createdByuserId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedByuserId() {
        return createdByuserId;
    }

    public void setCreatedByuserId(int createdByuserId) {
        this.createdByuserId = createdByuserId;
    }

    @Override
    public String toString() {
        return "Events{" +
                "eventId=" + eventId +
                ", eventIdIndex=" + eventIdIndex +
                ", userIds=" + userIds +
                ", startTime=" + startDateTime +
                ", endTime=" + endDateTime +
                ", createdAt=" + createdAt +
                ", createdByuserId=" + createdByuserId +
                '}';
    }
}
