package services;

import exception.ShiftNotFoundException;
import model.Shift;

import java.util.Date;

public interface ShiftService {

    Shift getShift(int shiftId) throws ShiftNotFoundException;

    Shift createShift(int userId, Date startTime, Date endDateTime);
}
