package com.switchfully.teamteam.parkshark.service.parking_lots;

import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;
import com.switchfully.teamteam.parkshark.service.EntityValidator;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotValidator extends EntityValidator<ParkingLot> {

    @Override
    protected boolean isAFieldEmptyOrNull(ParkingLot parkingLot) {
        return isNull(parkingLot)
                || isEmptyOrNull(parkingLot.getName())
                || isNull(parkingLot.getCapacity())
                || isNull(parkingLot.getPricePerHour());
    }
}
