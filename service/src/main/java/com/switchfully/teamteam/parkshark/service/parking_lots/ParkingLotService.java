package com.switchfully.teamteam.parkshark.service.parking_lots;

import com.switchfully.teamteam.parkshark.domain.models.ParkingLot;
import com.switchfully.teamteam.parkshark.domain.repositories.ParkingLotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot createParkingLot(ParkingLot parkingLotToCreate) {
        return parkingLotRepository.save(parkingLotToCreate);
    }

    public Iterable<ParkingLot> findAllParkingLots() {
        return parkingLotRepository.findAll();
    }

    public ParkingLot findParkingLotById(int id) {
       return parkingLotRepository.findById(id).orElse(null);
    }
}

