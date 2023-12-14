package model;

import java.util.Date;

public class Shift {

    private int shiftId;
    private int shiftIndex;
    private int userId;
    private Date startDateTime;
    private Date endDateTime;
    private Date createdAt;

    public Shift(int userId, Date startTime, Date endDateTime) {
        this.shiftId = shiftIndex++;
        this.userId = userId;
        this.startDateTime = startTime;
        this.endDateTime = endDateTime;
        this.createdAt = new Date();
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getStartTime() {
        return startDateTime;
    }

    public void setStartTime(Date startTime) {
        this.startDateTime = startTime;
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

    @Override
    public String toString() {
        return "Shift{" +
                "shiftId=" + shiftId +
                ", shiftIndex=" + shiftIndex +
                ", userId=" + userId +
                ", startTime=" + startDateTime +
                ", endTime=" + endDateTime +
                ", createdAt=" + createdAt +
                '}';
    }
}
