package dao;

import exception.ShiftNotFoundException;
import model.Shift;

import java.util.HashMap;
import java.util.Map;

public class ShiftDao {

    private final Map<Integer, Shift> shiftmap = new HashMap<>();

    public Shift getShift(int shiftId) throws ShiftNotFoundException {

        if (!shiftmap.containsKey(shiftId)) {
            throw new ShiftNotFoundException("shift not exist");
        }

        return shiftmap.get(shiftId);
    }

    public Shift createShift(Shift shift) {
        return shiftmap.put(shift.getShiftId(), shift);
    }
}
