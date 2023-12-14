package services.impl;

import dao.ShiftDao;
import exception.ShiftNotFoundException;
import model.Shift;
import services.ShiftService;

import java.util.Date;

public class ShiftServiceImpl implements ShiftService {

    private final ShiftDao shiftDao;

    public ShiftServiceImpl(ShiftDao shiftDao) {
        this.shiftDao = shiftDao;
    }

    @Override
    public Shift getShift(int shiftId) throws ShiftNotFoundException {
        return shiftDao.getShift(shiftId);
    }

    @Override
    public Shift createShift(int userId, Date startTime, Date endDateTime) {
        Shift shift = new Shift(userId, startTime, endDateTime);
        shiftDao.createShift(shift);
        return shift;
    }


}
